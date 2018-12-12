package project;

import java.io.Serializable;
import project.pieces.Rook;
import project.pieces.Queen;
import project.pieces.Pawns;
import project.pieces.Knight;
import project.pieces.King;
import project.pieces.Bishop;
import java.util.ArrayList;
import project.pieces.Piece;

/**
 *
 * @author Claire, Esther & Orann
 */
public class ChessBoard implements Serializable {

    private ArrayList<ArrayList<Square>> board;
    private ArrayList<Piece> blackPieces;
    private ArrayList<Piece> whitePieces;
    private Piece whiteKing;
    private Piece blackKing;
    public int SIZE = 8;
    public int A = (int) 'a';

    public ChessBoard() {
        whitePieces = new ArrayList<>();
        Rook rookW1 = new Rook(Color.WHITE, new Position(1, 'a'));
        whitePieces.add(rookW1);
        Knight knightW1 = new Knight(Color.WHITE, new Position(1, 'b'));
        whitePieces.add(knightW1);
        Bishop bishopW1 = new Bishop(Color.WHITE, new Position(1, 'c'));
        whitePieces.add(bishopW1);
        Queen queenW = new Queen(Color.WHITE, new Position(1, 'd'));
        whitePieces.add(queenW);
        whiteKing = new King(Color.WHITE, new Position(1, 'e'));
        whitePieces.add(whiteKing);
        Bishop bishopW2 = new Bishop(Color.WHITE, new Position(1, 'f'));
        whitePieces.add(bishopW2);
        Knight knightW2 = new Knight(Color.WHITE, new Position(1, 'g'));
        whitePieces.add(knightW2);
        Rook rookW2 = new Rook(Color.WHITE, new Position(1, 'h'));
        whitePieces.add(rookW2);

        blackPieces = new ArrayList<>();
        Rook rookB1 = new Rook(Color.BLACK, new Position(8, 'a'));
        blackPieces.add(rookB1);
        Knight knightB1 = new Knight(Color.BLACK, new Position(8, 'b'));
        blackPieces.add(knightB1);
        Bishop bishopB1 = new Bishop(Color.BLACK, new Position(8, 'c'));
        blackPieces.add(bishopB1);
        Queen queenB = new Queen(Color.BLACK, new Position(8, 'd'));
        blackPieces.add(queenB);
        blackKing = new King(Color.BLACK, new Position(8, 'e'));
        blackPieces.add(blackKing);
        Bishop bishopB2 = new Bishop(Color.BLACK, new Position(8, 'f'));
        blackPieces.add(bishopB2);
        Knight knightB2 = new Knight(Color.BLACK, new Position(8, 'g'));
        blackPieces.add(knightB2);
        Rook rookB2 = new Rook(Color.BLACK, new Position(8, 'h'));
        blackPieces.add(rookB2);

        board = new ArrayList<>();

        //Black pieces
        ArrayList<Square> line = new ArrayList<>();
        line.add(new Square(rookB1));
        line.add(new Square(knightB1));
        line.add(new Square(bishopB1));
        line.add(new Square(queenB));
        line.add(new Square(blackKing));
        line.add(new Square(bishopB2));
        line.add(new Square(knightB2));
        line.add(new Square(rookB2));
        board.add(line);

        //Black pawns
        line = new ArrayList<>();
        for (int i = 97; i <= 104; i++) {
            line.add(new Square(new Pawns(Color.BLACK, new Position(7, (char) i))));
        }
        board.add(line);

        for (int i = 0; i < 4; i++) {
            line = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                line.add(new Square(null));
            }
            board.add(line);
        }

        //White pawns
        line = new ArrayList<>();
        for (int i = 97; i <= 104; i++) {
            line.add(new Square(new Pawns(Color.WHITE, new Position(2, (char) i))));
        }
        board.add(line);

        //White pieces
        line = new ArrayList<>();
        line.add(new Square(rookW1));
        line.add(new Square(knightW1));
        line.add(new Square(bishopW1));
        line.add(new Square(queenW));
        line.add(new Square(whiteKing));
        line.add(new Square(bishopW2));
        line.add(new Square(knightW2));
        line.add(new Square(rookW2));
        board.add(line);
    }

    public ChessBoard(ChessBoard board) {
        this.board = new ArrayList<>();

    }

    public void doMove(Move move) {
        Square squareTo = this.getSquare(move.getTo());
        Square squareFrom = this.getSquare(move.getFrom());
        squareFrom.getPiece().setPosition(new Position(move.getTo()));
        
        if(!squareTo.isEmpty()){
            Piece deadPiece = squareTo.getPiece();
            if (deadPiece.getColor() == Color.BLACK){
                blackPieces.remove(deadPiece);
            }
            else{
                whitePieces.remove(deadPiece);
            }
        }

        squareTo.setPiece(squareFrom.getPiece());
        squareFrom.setPiece(null);
    }

    public ArrayList<ArrayList<Square>> getBoard() {
        return board;
    }

    public Square getNeighbour(Position pos, int xOffset, int yOffset) {
        int x = pos.getX();
        char y = pos.getY();
        int neighbourX = (SIZE - (x + xOffset));
        int neighbourY = (y - A) + yOffset;
        Square ret = null;
        if ((neighbourX >= 0) && (neighbourX < SIZE) && (neighbourY >= 0) && (neighbourY < SIZE)) {
            ret = board.get(neighbourX).get(neighbourY);
        }
        return ret;
    }

    public Square getSquare(Position p) {
        return board.get(SIZE - p.getX()).get(p.getY() - A);
    }

    @Override
    public String toString() {
        String ret = "  ";
        for (int i = 0; i < SIZE; i++) {
            ret += "  ";
            ret += (char) (i + 65);
            ret += " ";
        }
        ret += "\n  ---------------------------------\n";
        for (int i = 0; i < SIZE; i++) {
            ret += (SIZE - i) + " |";
            for (int j = 0; j < SIZE; j++) {
                Piece p = board.get(i).get(j).getPiece();
                if (p != null) {
                    ret += board.get(i).get(j).toString();
                } else {
                    ret += "   ";
                }
                ret += "|";
            }
            ret += "\n";
            ret += "  ---------------------------------\n";
        }
        return ret;
    }

    public void setKingWeight(Color c) {
        if (c == Color.BLACK) {
            getSquare(new Position(8, 'e')).getPiece().setWeight(200);
            System.out.println("BLACK KING : " + getSquare(new Position(8, 'e')).getPiece().getWeight());
        } else {
            getSquare(new Position(1, 'e')).getPiece().setWeight(200);
            System.out.println("WHITE KING : " + getSquare(new Position(1, 'e')).getPiece().getWeight());
        }
    }

    boolean isCheck(Color c) {
        ArrayList<Piece> ennemies;
        Position kingPosition;
        ArrayList<Position> possibleMoves;
        Piece ennemyPiece;
        boolean isCheck = false;
        int i = 0;

        if (c == Color.BLACK) {
            kingPosition = blackKing.getPosition();
            ennemies = whitePieces;
        } else {
            kingPosition = whiteKing.getPosition();
            ennemies = blackPieces;
        }

        while (!isCheck && i < ennemies.size()) {
            ennemyPiece = ennemies.get(i);
            possibleMoves = ennemyPiece.getPossibleMoves(this);
            for (int j = 0; j < possibleMoves.size(); j++) {
                if (possibleMoves.get(j).equals(kingPosition)) {
                    isCheck = true;
                }
            }
            i++;
        }
        return isCheck;
    }

    public ArrayList<Piece> getPieces(Color c) {
        if (c == Color.BLACK) {
            return this.blackPieces;
        } else {
            return this.whitePieces;
        }
    }
    
    public Piece getKing(Color c){
        if (c == Color.BLACK){
            return this.blackKing;
        }
        else{
            return this.whiteKing;
        }
    }

}
