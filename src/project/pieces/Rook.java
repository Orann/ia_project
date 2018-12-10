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
        weight = 5;
    }

    @Override
    public ArrayList<Position> getPossibleMoves(ChessBoard game) {
        int row = position.getX();
        int column = (int) position.getY()-'a';
        ArrayList<Position> possibleMoves = new ArrayList<>();
        //all possible moves in the up
        for (int i = row + 1; i < game.SIZE; i++) {
            Square square = game.getBoard().get(i).get(column);
            if (square.getPiece() == null) {
                possibleMoves.add(new Position(i, position.getY()));
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(new Position(i, position.getY()));
                break;
            } else {
                break;
            }
        }
        //all possible moves in the down
        for (int i = row - 1; i > -1; i--) {
            Square square = game.getBoard().get(i).get(column);
            if (square.getPiece() == null) {
                possibleMoves.add(new Position(i, position.getY()));
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(new Position(i, position.getY()));
                break;
            } else {
                break;
            }
        }
        //all possible moves to the right
        for (int i = column + 1; i < game.SIZE; i++) {
            Square square = game.getBoard().get(row).get(i);
            if (square.getPiece() == null) {
                possibleMoves.add(new Position(position.getX(),(char) (i+'a')));
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(new Position(position.getX(),(char) (i+'a')));
                break;
            } else {
                break;
            }
        }
        //all possible moves to the left
        for (int i = column - 1; i > -1; i--) {
            Square square = game.getBoard().get(row).get(i);
            if (square.getPiece() == null) {
                possibleMoves.add(new Position(position.getX(),(char) (i+'a')));
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(new Position(position.getX(),(char) (i+'a')));
                break;
            } else {
                break;
            }
        }
        return possibleMoves;
    }

}
