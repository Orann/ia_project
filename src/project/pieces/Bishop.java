package project.pieces;

import java.util.ArrayList;
import project.ChessBoard;
import project.Color;
import project.Position;
import project.Square;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Bishop extends Piece{

    public Bishop(Color color, Position position) {
        super(color, position);
        weight = 3;
    }

    @Override
    public ArrayList<Position> getPossibleMoves(ChessBoard game) {
        
        int row = position.getX();
        int column = (int) position.getY()-'a';
        ArrayList<Position> possibleMoves = new ArrayList<>();
        //all possible moves in the down positive diagonal
        for (int j = column + 1, i = row + 1; j < game.SIZE && i < game.SIZE; j++, i++) {
            Square square = game.getBoard().get(i).get(j);
            if (square.getPiece() == null) {
                possibleMoves.add(new Position(i, (char)(j+'a')));
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(new Position(i, (char)(j+'a')));
                break;
            } else {
                break;
            }
        }
        //all possible moves in the up positive diagonal
        for (int j = column - 1, i = row + 1; j > -1 && i < game.SIZE; j--, i++) {
            Square square = game.getBoard().get(i).get(j);
            if (square.getPiece() == null) {
                possibleMoves.add(new Position(i, (char)(j+'a')));
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(new Position(i, (char)(j+'a')));
                break;
            } else {
                break;
            }
        }
        //all possible moves in the up negative diagonal
        for (int j = column - 1, i = row - 1; j > -1 && i > -1; j--, i--) {
            Square square = game.getBoard().get(i).get(j);
            if (square.getPiece() == null) {
                possibleMoves.add(new Position(i, (char)(j+'a')));
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(new Position(i, (char)(j+'a')));
                break;
            } else {
                break;
            }
        }
        //all possible moves in the down negative diagonal
        for (int j = column + 1, i = row - 1; j < game.SIZE && i > -1; j++, i--) {
            Square square = game.getBoard().get(i).get(j);
            if (square.getPiece() == null) {
                possibleMoves.add(new Position(i, (char)(j+'a')));
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(new Position(i, (char)(j+'a')));
                break;
            } else {
                break;
            }
        }
        return possibleMoves;
    }

    
}
