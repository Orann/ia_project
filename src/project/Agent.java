package project;

import java.util.ArrayList;
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
    private static final int MAX_DEPTH = 5;
    private final int MAX_HEURISTIC = 1000;

    public Agent(Sensor sensor, Effector effector) {
        this.belief = new ChessBoard();
        this.sensor = sensor;
        this.effector = effector;
    }
    
    public void minMax(){
        Node root = new Node("", -1 , true);
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
            ArrayList<String> moves = getAllPossibleMoves(n.isOurMove(), tmpChessBoard);
            int bestHeuristic = bestHeuristicInit(n.isOurMove());
            int heuristic;
            for(String move : moves){
                Node newNode = new Node(move, -1, true); //-1 because node's heuristic isn't known yet
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

    private ArrayList<String> getAllPossibleMoves(boolean ourMove, ChessBoard currentBoard) {
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
    private int getMoveHeuristic(String move, ChessBoard tmpChessBoard) {
        return -1;
    }

}
