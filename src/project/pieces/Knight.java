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
public class Knight extends Piece{

    public Knight(Color color, Position position) {
        super(color, position);
        weight = 3;
    }

    @Override
    public ArrayList<Position> getPossibleMoves(ChessBoard game) {
        int x = this.position.getX();
        char y = this.position.getY();
        ArrayList<Position> possibleMoves = new ArrayList<>();
        int[][] offsets = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
        };
        for (int[] o : offsets) {
            Square square = game.getNeighbour(x-1,(int) (y - 'a'),o[0], o[1]);
            if (square != null && (square.getPiece() == null || isOpponent(square.getPiece()))) {
                possibleMoves.add(new Position(x+o[0], (char) (y+o[1])));
            }
        }
        return possibleMoves;
    }

    
}
