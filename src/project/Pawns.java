package project;

import java.util.ArrayList;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Pawns extends Piece {

    public Pawns(Color color, Position position) {
        super(color, position);
    }

    @Override
    public ArrayList<Position> getPossibleMoves(ChessBoard game) {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        boolean color = (this.getColor() == Color.WHITE);
        int dx = color ? -1 : 1;
        int x = this.position.getX();
        char y = this.position.getY();

        Square ahead = game.getNeighbour(x-1,(int) (y - 'a'),dx, 0);
        if (ahead.getPiece() == null) {
            possibleMoves.add(new Position(ahead.getPiece().getPosition()));
            if (x == 6 && color) {
                Square aheadsecond = game.getNeighbour(x-1,(int) (y - 'a'),dx - 1, 0);
                if (aheadsecond.getPiece() == null) {
                    possibleMoves.add(new Position(aheadsecond.getPiece().getPosition()));
                }
            } else if (x == 1 && !color) {
                Square aheadsecond = game.getNeighbour(x-1,(int) (y - 'a'),dx + 1, 0);
                if (aheadsecond.getPiece() == null) {
                    possibleMoves.add(new Position(aheadsecond.getPiece().getPosition()));
                }
            }
        }
        Square aheadLeft = game.getNeighbour(x-1,(int) (y - 'a'),dx, -1);
        if (aheadLeft != null && aheadLeft.getPiece() != null && isOpponent(aheadLeft.getPiece())) {
            possibleMoves.add(new Position(aheadLeft.getPiece().getPosition()));
        }
        Square aheadRight = game.getNeighbour(x-1,(int) (y - 'a'),dx, 1);
        if (aheadRight != null && aheadRight.getPiece() != null && isOpponent(aheadRight.getPiece())) {
            possibleMoves.add(new Position(aheadRight.getPiece().getPosition()));
        }
        return possibleMoves;
    }

}
