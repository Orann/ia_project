package project;

import java.util.ArrayList;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Node {
    private ArrayList<Position> move;
    private int heuristic;
    private ArrayList<Node> children;
    private boolean isOurMove;

    public Node(Position from, Position to, int heuristic, boolean isOurMove) {
        this.move = new ArrayList<>();
        this.move.add(from);
        this.move.add(to);
        this.heuristic = heuristic;
        this.children = new ArrayList<>();
        this.isOurMove = isOurMove;
    }
    
    public void addChild(Node child){
        this.children.add(child);
    }

    public ArrayList<Position> getMove() {
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

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }
    
    
}
