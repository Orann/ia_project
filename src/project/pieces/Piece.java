package project.pieces;

import java.io.Serializable;
import java.util.ArrayList;
import project.ChessBoard;
import project.Color;
import project.Position;

/**
 * cf https://github.com/casz/chess/tree/master/src/model
 * pour les fonctions getPossibleMoves()
 * 
 * @author Claire, Esther & Orann
 */
public abstract class Piece  implements Serializable {
    private Color color;
    protected Position position;
    protected String name;
    protected int weight;

    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }
    
    public Piece(Piece p){
        this.color = p.color;
        this.name = p.name;
        this.weight = p.weight;
        this.position = new Position(p.getPosition());
    }
    
    public abstract ArrayList<Position> getPossibleMoves(ChessBoard game);

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getWeight() {
        return weight;
    }   
    
    protected boolean isOpponent(Piece neighbour) {
        return !(neighbour.getColor() == this.color);
    }

    @Override
    public String toString() {
        return this.color.toString()+this.name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
   
}
