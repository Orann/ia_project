package project;

import java.util.ArrayList;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Node {
    private String move;
    private int heuristic;
    private ArrayList<Node> children;
    private boolean isOurMove;

    public Node(String move, int heuristic, boolean isOurMove) {
        this.move = move;
        this.heuristic = heuristic;
        this.children = new ArrayList<>();
        this.isOurMove = isOurMove;
    }
    
    public void addChild(Node child){
        this.children.add(child);
    }

    public String getMove() {
        return move;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public boolean isOurMove() {
        return isOurMove;
    }
}
