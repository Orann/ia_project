package project;

import java.util.ArrayList;

/**
 *
 * @author Claire, Esther & Orann
 */
public abstract class Piece {
    private Color color;
    private Position position;

    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }
    
    public abstract ArrayList<Position> getPossibleMoves();

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }    
}
