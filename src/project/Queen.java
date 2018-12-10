package project;

import java.util.ArrayList;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Queen extends Piece{

    public Queen(Color color, Position position) {
        super(color, position);
    }

    @Override
    public ArrayList<Position> getPossibleMoves(ChessBoard game) {        
        ArrayList<Position> possibleMoves = new ArrayList<>();
        Piece[] pieces = { 
            new Bishop(this.getColor(), this.getPosition()), 
            new Rook(this.getColor(), this.getPosition())
        };
        
        for (Piece piece : pieces) {
            possibleMoves.addAll(piece.getPossibleMoves(game));
        }
        return possibleMoves;   
    }
}
