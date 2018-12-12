package project;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Node {
    private Move move;
    private int heuristic;
    private final int HEURISTIC_INIT = 12000;
    private final Node parent;

    public Node(Move move, Node parent) {
        this.move = move;
        this.heuristic = HEURISTIC_INIT;
        this.parent = parent;
    }    

    public Move getMove() {
        return move;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public Node getParent() {
        return parent;
    }
    
    public boolean isHeuristicInit(){
        return heuristic==HEURISTIC_INIT;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
