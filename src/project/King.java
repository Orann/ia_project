package project;

import java.util.ArrayList;

/**
 *
 * @author Claire, Esther & Orann
 */
public class King extends Piece{

    public King(Color color, Position position) {
        super(color, position);
    }

    @Override
    public ArrayList<Position> getPossibleMoves() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
