package project;

import java.util.ArrayList;
import org.apache.commons.lang3.SerializationUtils;
import project.pieces.Piece;

/**
 * TODO : * currently, heuristic depends only of the leafs, but it has to depend
 * of the parent nodes (perhaps by additioning them while calculing the best
 * heuristic ?) * implement getMoveHeuristic() * implement getAllPossibleMoves()
 * for King * for all methods getAllPossibleMoves : verify that conversition
 * between position int-char and position in board is correct (perhaps will need
 * to have 2 lists of the pieces that are currently on the board, one for our
 * pieces, and one for the opponent's) * when we have the best heuristic, how to
 * find the corresponding move ?
 *
 * @author Claire, Esther & Orann
 */
public class Agent {

    private final ChessBoard belief;
    private Color color;
    private Node rootNode;

    private static final int MAX_DEPTH = 3;
    private final int MAX_HEURISTIC = 1000;

    public Agent() {
        this.belief = new ChessBoard();
        this.color = Color.BLACK;
        
    }

    public void setColor(Color color) {
        this.color = color;
        this.belief.setKingWeight(color);
    }

    public Move minMax() {
        System.out.println("MinMax ! ");
        rootNode = new Node(null, null);
        ConstructTree(rootNode, 0, SerializationUtils.clone(this.belief));
        return rootNode.getMove();
    }

    /**
     * Construct the min max tree of a fixed depth
     *
     * @param n
     * @param depth
     * @param tmpChessBoard
     * @return the best heuristic of the leafs
     */
    public int ConstructTree(Node n, int depth, ChessBoard tmpChessBoard) {
        ChessBoard newChessBoard;
        if (depth == MAX_DEPTH) {
            int heuristic = calculateHeuristic(tmpChessBoard);
            if (n.getParent().isHeuristicInit() || isBestHeuristic(heuristic, n.getParent().getHeuristic(), depth)) {
                n.getParent().setHeuristic(heuristic);
            }
            return heuristic;
        } else {
            boolean isOurMove = (depth % 2 == 0);
            ArrayList<Move> moves = getAllPossibleMoves(isOurMove, tmpChessBoard);
            //System.out.println(tmpChessBoard);
            for (Move move : moves) {
                Node newNode = new Node(move, n);
                newChessBoard = SerializationUtils.clone(tmpChessBoard);
                newChessBoard.doMove(newNode.getMove());
                ConstructTree(newNode, depth + 1, newChessBoard);
            }
            if (n.getParent() != null) {

                if (n.getParent().isHeuristicInit() || isBestHeuristic(n.getHeuristic(), n.getParent().getHeuristic(), depth)) {
                    n.getParent().setHeuristic(n.getHeuristic());
                    if (n.getParent() == rootNode) {
                        rootNode.setMove(n.getMove());
                    }
                }
            }
            return n.getHeuristic();
        }
    }

    public ArrayList<Move> getAllPossibleMoves(boolean ourMove, ChessBoard currentBoard) {
        Piece piece;
        Position positionPiece;
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Color colorMove;
        if (ourMove) {
            colorMove = color;
        } else {
            if (color == Color.BLACK) {
                colorMove = Color.WHITE;
            } else {
                colorMove = Color.BLACK;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                piece = currentBoard.getBoard().get(i).get(j).getPiece();
                if (piece != null) {
                    positionPiece = piece.getPosition();
                    if (piece.getColor() == colorMove) {
                        for (Position to : piece.getPossibleMoves(currentBoard)) {
                            possibleMoves.add(new Move(positionPiece, to));
                        }
                    }
                }
            }
        }
        return possibleMoves;
    }

    private int bestHeuristicInit(boolean ourMove) {
        int ret;
        if (ourMove) {
            ret = 0;
        } else {
            ret = MAX_HEURISTIC;
        }
        return ret;
    }

    /**
     * Determines if an heuristic is a better heuristic than the current best
     * Taking account if heuritics have to be minimized of maximized
     *
     * @param candidateHeuristic
     * @param currentBestHeuristic
     * @param ourMove : true if heuristics concerne one of our agent's move,
     * false if they concern the opponent's moves
     * @return
     */
    private boolean isBestHeuristic(int candidateHeuristic, int parentHeuristic, int depth) {
        boolean ret = false;
        if ((!(depth % 2 == 0) && (candidateHeuristic > parentHeuristic))
                || ((depth % 2 == 0) && (candidateHeuristic < parentHeuristic))) {
            ret = true;
        }
        return ret;
    }

    /**
     * Asks the sensor to know the heuristic of move in the board of
     * tmpChessBoard
     *
     * @param move
     * @param tmpChessBoard
     * @return
     */
    private int getMoveHeuristic(ArrayList<Position> move, ChessBoard tmpChessBoard) {
        Square piece = tmpChessBoard.getSquare(move.get(0));
        int heuristic = -1 * (piece.getPiece().getWeight());

        Square goTo = tmpChessBoard.getSquare(move.get(1));
        if (goTo.getPiece() != null) {
            heuristic += goTo.getPiece().getWeight();
        }

        return heuristic;
    }

    /**
     * Asks the sensor to know the heuristic of move in the board of
     * tmpChessBoard
     *
     * @param tmpChessBoard
     * @return
     */
    private int calculateHeuristic(ChessBoard tmpChessBoard) {
        Piece piece;
        int heuristic = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                piece = tmpChessBoard.getBoard().get(i).get(j).getPiece();
                if (piece != null) {
                    if (piece.getColor() == color) {
                        heuristic += piece.getWeight();
                    } else {
                        heuristic -= piece.getWeight();
                    }
                }
            }
        }
        return heuristic;
    }

    public ChessBoard getBelief() {
        return belief;
    }

    
}
