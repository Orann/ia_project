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
public class Pawns extends Piece {
    Position intialPosition;

    public Pawns(Color color, Position position) {
        super(color, position);
        intialPosition = this.position;
        this.name = "P ";
        weight = 1;
    }

    @Override
    public ArrayList<Position> getPossibleMoves(ChessBoard game) {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        boolean isWhite = (this.getColor() == Color.WHITE);
        int dx = isWhite ? 1 : -1;
        int x = this.position.getX();
        char y = this.position.getY();

        Square ahead = game.getNeighbour(this.position, dx, 0);
        if (ahead != null && ahead.isEmpty()) {
            possibleMoves.add(new Position(x+dx, y));
            if (this.position.equals(this.intialPosition)) {
                Square aheadsecond = game.getNeighbour(this.position, 2*dx, 0);
                if (aheadsecond!=null && aheadsecond.isEmpty()) {
                    possibleMoves.add(new Position(x+(2*dx), y));
                }
            }
        }

        Square aheadLeft = game.getNeighbour(this.position, dx, -1);
        if (aheadLeft != null && !aheadLeft.isEmpty() && isOpponent(aheadLeft.getPiece())) {
            possibleMoves.add(new Position(aheadLeft.getPiece().getPosition()));
        }
        Square aheadRight = game.getNeighbour(this.position, dx, 1);
        if (aheadRight != null && !aheadRight.isEmpty() && isOpponent(aheadRight.getPiece())) {
            possibleMoves.add(new Position(aheadRight.getPiece().getPosition()));
        }
        return possibleMoves;
    }

}
