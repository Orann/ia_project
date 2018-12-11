package project.pieces;

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
public abstract class Piece {
    private Color color;
    protected Position position;
    String name;

    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
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
    
    
    protected boolean isOpponent(Piece neighbour) {
        return !(neighbour.getColor() == this.color);
    }

    @Override
    public String toString() {
        return this.color.toString()+this.name;
    }
    
    
    
    
}
