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
public class Bishop extends Piece {

    public Bishop(Color color, Position position) {
        super(color, position);
        this.name = "B ";
    }

    @Override
    public ArrayList<Position> getPossibleMoves(ChessBoard game) {

        int row = position.getX();
        int column = position.getY();
        ArrayList<Position> possibleMoves = new ArrayList<>();
        //all possible moves in the down positive diagonal
        Position p;
        int i = row + 1;
        char j = (char) (column + 1);
        while (i <game.SIZE && j <='h') {
            p = new Position(i, j);
            Square square = game.getSquare(p);
            if (square != null && square.isEmpty()) {
                possibleMoves.add(p);
            } else if (square != null && isOpponent(square.getPiece())) {
                possibleMoves.add(p);
                break;
            } else {
                break;
            }
            i++;
            j++;
        }
        
        //all possible moves in the up positive diagonal
         i = row + 1;
         j = (char) (column - 1);
        while (i < game.SIZE && j >= 'a') {
            p = new Position(i, j);
            Square square = game.getSquare(p);
            if (square != null && square.isEmpty()) {
                possibleMoves.add(p);
            } else if (square != null && isOpponent(square.getPiece())) {
                possibleMoves.add(p);
                break;
            } else {
                break;
            }
            i++;
            j--;
        }
        
        //all possible moves in the up negative diagonal
         i = row - 1;
         j = (char) (column - 1);
        while (i > 0 && j >= 'a') {
            p = new Position(i, j);
            Square square = game.getSquare(p);
            if (square != null && square.isEmpty()) {
                possibleMoves.add(p);
            } else if (square != null && isOpponent(square.getPiece())) {
                possibleMoves.add(p);
                break;
            } else {
                break;
            }
            i--;
            j--;
        }

        //all possible moves in the down negative diagonal
         i = row - 1;
         j = (char) (column + 1);
        while (i > 0 && j <= 'h') {
            p = new Position(i, j);
            Square square = game.getSquare(p);
            if (square != null && square.isEmpty()) {
                possibleMoves.add(p);
            } else if (square != null && isOpponent(square.getPiece())) {
                possibleMoves.add(p);
                break;
            } else {
                break;
            }
            i--;
            j++;
        }
        return possibleMoves;
    }

}
