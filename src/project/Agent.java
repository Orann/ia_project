package project;

import java.util.ArrayList;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Agent {
    private ChessBoard belief;
    private Sensor sensor;
    private Effector effector;
    private static int maxDepth = 5;

    public Agent(Sensor sensor, Effector effector) {
        this.belief = new ChessBoard();
        this.sensor = sensor;
        this.effector = effector;
    }
    
    public void minMax(){
        
    }
    
    //TODO :quand on récupère les heurisitques dans la boucles, 
    //calculer le min ou le max, ça dépend
    //Pour étiquetter les noeuds
    //+ problème de comment obtenir l'heurisitque des feuilles
    public int ConstructTree(Node n, int depth, ChessBoard tmpChessBoard){
        if (depth == maxDepth){
            return n.getHeuristic();
        }
        else{
            ChessBoard newChessBoard = tmpChessBoard.clone();
            newChessBoard.doMove(n.getMove());
            ArrayList<String> moves = getAllPossibleMoves(n.isOurMove());
            int heuristic = -1;
            for(String move : moves){
                //Probblème avec l'heuristiquen, problèmes partout en fait
                Node newNode = new Node(move, -1, true); //-1 comme heuristique, parce qu'on ne connait pas encore la valeur du noeud
                n.addChild(newNode);
                heuristic = ConstructTree(newNode, depth+1, newChessBoard);
                
            }
            return heuristic;
        }            
    }

    private ArrayList<String> getAllPossibleMoves(boolean ourMove) {
        return null;
    }
}
