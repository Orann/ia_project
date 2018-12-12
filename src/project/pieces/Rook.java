package project.pieces;

import project.pieces.Piece;
import java.util.ArrayList;
import project.ChessBoard;
import project.Color;
import project.Position;
import project.Square;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Rook extends Piece {

    public Rook(Color color, Position position) {
        super(color, position);
        this.name = "R ";
        weight = 5;
    }
    

    @Override
    public ArrayList<Position> getPossibleMoves(ChessBoard game) {
        int row = position.getX();
        int column = position.getY();
        ArrayList<Position> possibleMoves = new ArrayList<>();
        //all possible moves in the up
        Position p;
        for (int i = row + 1; i < game.SIZE; i++) {
            p = new Position(i, position.getY());
            Square square = game.getSquare(p);
            if (square != null && square.isEmpty()) {
                possibleMoves.add(p);
            } else if (square != null && isOpponent(square.getPiece())) {
                possibleMoves.add(p);
                break;
            } else {
                break;
            }
        }
        //all possible moves in the down
        for (int i = row - 1; i > 0; i--) {
            p = new Position(i, position.getY());
            Square square = game.getSquare(p);
            if (square != null && square.isEmpty()) {
                possibleMoves.add(p);
            } else if (square != null && isOpponent(square.getPiece())) {
                possibleMoves.add(p);
                break;
            } else {
                break;
            }
        }
        //all possible moves to the right
        for (char i = (char) (column + 1); i <='h'; i++) {
            p = new Position(position.getX(), i);
            Square square = game.getSquare(p);
            if (square != null && square.isEmpty()) {
                possibleMoves.add(p);
            } else if (square != null && isOpponent(square.getPiece())) {
                possibleMoves.add(p);
                break;
            } else {
                break;
            }
        }
        //all possible moves to the left
        for (char i = (char) (column - 1); i >= 'a'; i--) {
            p = new Position(position.getX(), i);
            Square square = game.getSquare(p);
            if (square != null && square.isEmpty()) {
                possibleMoves.add(p);
            } else if (square != null && isOpponent(square.getPiece())) {
                possibleMoves.add(p);
                break;
            } else {
                break;
            }
        }
        return possibleMoves;
    }

}
