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
public class King extends Piece{

    public King(Color color, Position position) {
        super(color, position);
        this.name = "Ki";
    }
    
    boolean inCheck;

    @Override
    public ArrayList<Position> getPossibleMoves(ChessBoard game) {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        int[][] offsets = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
            {1, 1},
            {-1, 1},
            {-1, -1},
            {1, -1}
        };
        for (int[] o : offsets) {
            Square square = game.getNeighbour(this.position, o[0], o[1]);
            if (square != null && (square.getPiece() == null || isOpponent(square.getPiece()))) {
                possibleMoves.add(new Position(this.position.getX()+o[0], (char) (this.position.getY()+o[1])));
            }
        }
        return possibleMoves;
    }
    
}
