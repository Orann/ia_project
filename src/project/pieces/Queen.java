package project.pieces;

import project.pieces.Piece;
import project.pieces.Bishop;
import java.util.ArrayList;
import project.ChessBoard;
import project.Color;
import project.Position;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Queen extends Piece{

    public Queen(Color color, Position position) {
        super(color, position);
        this.name = "Q ";
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
