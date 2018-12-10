package project;

import java.util.ArrayList;
import project.pieces.Piece;
/**
 *  TODO : 
 * * currently, heuristic depends only of the leafs, but it has to depend of the parent nodes
 *   (perhaps by additioning them while calculing the best heuristic ?)
 * * implement getMoveHeuristic()
 * * implement getAllPossibleMoves() for King
 * * for all methods getAllPossibleMoves : verify that conversition between position int-char and position in board is correct
 *   (perhaps will need to have 2 lists of the pieces that are currently on the board, 
 *   one for our pieces, and one for the opponent's)
 * * when we have the best heuristic, how to find the corresponding move ? 
 * 
 * @author Claire, Esther & Orann
 */
public class Agent {
    private final ChessBoard belief;
    private final Sensor sensor;
    private final Effector effector;
    private Color color;
    private static final int MAX_DEPTH = 5;
    private final int MAX_HEURISTIC = 1000;

    public Agent(Sensor sensor, Effector effector) {
        this.belief = new ChessBoard();
        this.sensor = sensor;
        this.effector = effector;
        this.color = Color.BLACK;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void minMax(){
        Node root = new Node(new Position(0, '0'), new Position(0, '0'), -1 , true);
        int maxHeuristic = ConstructTree(root, 0, belief.clone());
    }
    
    /**
     * Construct the min max tree of a fixed depth
     * @param n
     * @param depth
     * @param tmpChessBoard
     * @return the best heuristic of the leafs
     */
    public int ConstructTree(Node n, int depth, ChessBoard tmpChessBoard){
        if (depth == MAX_DEPTH){
            int heuristic = getMoveHeuristic(n.getMove(), tmpChessBoard);
            n.setHeuristic(heuristic);
            return heuristic;
        }
        else{
            ChessBoard newChessBoard = tmpChessBoard.clone();
            newChessBoard.doMove(n.getMove());
            ArrayList<ArrayList<Position>> moves = getAllPossibleMoves(n.isOurMove(), tmpChessBoard);
            int bestHeuristic = bestHeuristicInit(n.isOurMove());
            int heuristic;
            for(ArrayList<Position> move : moves){
                Node newNode = new Node(move.get(0), move.get(1), -1, true); //-1 because node's heuristic isn't known yet
                n.addChild(newNode);
                heuristic = ConstructTree(newNode, depth+1, newChessBoard);
                if(isBestHeuristic(heuristic, bestHeuristic, n.isOurMove())){
                    bestHeuristic = heuristic;
                }                
            }
            n.setHeuristic(bestHeuristic);
            return bestHeuristic;
        }            
    }

    private ArrayList<ArrayList<Position>> getAllPossibleMoves(boolean ourMove, ChessBoard currentBoard) {
        Piece piece; 
        ArrayList<Position> move;
        ArrayList<ArrayList<Position>> possibleMoves = new ArrayList<>();
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                piece = currentBoard.getBoard().get(i).get(j).getPiece();
                if(piece != null){
                    if(piece.getColor() == color){
                        
                    }                    
                }
                
            }
        }
        
        return null;
    }

    private int bestHeuristicInit(boolean ourMove) {
        int ret;
        if (ourMove){
            ret = 0;
        }
        else{
            ret = MAX_HEURISTIC;
        }
        return ret;
    }

    
    /**
     * Determines if an heuristic is a better heuristic than the current best
     * Taking account if heuritics have to be minimized of maximized
     * @param candidateHeuristic
     * @param currentBestHeuristic
     * @param ourMove : true if heuristics concerne one of our agent's move, false if they concern the opponent's moves
     * @return 
     */
    private boolean isBestHeuristic(int candidateHeuristic, int currentBestHeuristic, boolean ourMove) {
        boolean ret = false;
        if((ourMove && (candidateHeuristic>currentBestHeuristic)) || 
                (!ourMove && (candidateHeuristic<currentBestHeuristic))){
            ret = true;
        }
        return ret;
    }

    /**
     * Asks the sensor to know the heuristic of move in the board of tmpChessBoard
     * @param move
     * @param tmpChessBoard
     * @return 
     */
    private int getMoveHeuristic(ArrayList<Position> move, ChessBoard tmpChessBoard) {       
        Square piece = tmpChessBoard.getSquare(move.get(0));
        int heuristic = -1 * (piece.getPiece().getWeight());
        
        Square goTo = tmpChessBoard.getSquare(move.get(1));
        if(goTo.getPiece() != null){
           heuristic += goTo.getPiece().getWeight();
        }
        
        return heuristic;
    }

}
