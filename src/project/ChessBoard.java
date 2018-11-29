package project;

import java.util.ArrayList;

/**
 *
 * @author Claire, Esther & Orann
 */
public class ChessBoard {
    private ArrayList<ArrayList<Square>> board;
    public int SIZE = 8;

    public ChessBoard() {
        Rook rookW1 = new Rook(Color.WHITE, new Position(1, 'a'));
        Knight knightW1 = new Knight(Color.WHITE, new Position(1, 'b'));
        Bishop bishopW1 = new Bishop(Color.WHITE, new Position(1, 'c'));
        Queen queenW = new Queen(Color.WHITE, new Position(1, 'd'));
        King kingW = new King(Color.WHITE, new Position(1, 'e'));
        Bishop bishopW2 = new Bishop(Color.WHITE, new Position(1, 'f'));
        Knight knightW2 = new Knight(Color.WHITE, new Position(1, 'g'));
        Rook rookW2 = new Rook(Color.WHITE, new Position(1, 'h'));
        
        
        
        Rook rookB1 = new Rook(Color.BLACK, new Position(8, 'a'));
        Knight knightB1 = new Knight(Color.BLACK, new Position(8, 'b'));
        Bishop bishopB1 = new Bishop(Color.BLACK, new Position(8, 'c'));
        Queen queenB = new Queen(Color.BLACK, new Position(8, 'd'));
        King kingB = new King(Color.BLACK, new Position(8, 'e'));
        Bishop bishopB2 = new Bishop(Color.BLACK, new Position(8, 'f'));
        Knight knightB2 = new Knight(Color.BLACK, new Position(8, 'g'));
        Rook rookB2 = new Rook(Color.BLACK, new Position(8, 'h'));
        
        board = new ArrayList<>();
        
        //Black pieces
        ArrayList<Square> line = new ArrayList<>();
        line.add(new Square(rookB1));
        line.add(new Square(knightB1));
        line.add(new Square(bishopB1));
        line.add(new Square(queenB));
        line.add(new Square(kingB));
        line.add(new Square(bishopB2));
        line.add(new Square(knightB2));
        line.add(new Square(rookB2));
        board.add(line);
        
        //Black pawns
        line = new ArrayList<>();
        for(int i = 97 ; i<= 104; i++){
            line.add(new Square(new Pawns(Color.BLACK, new Position(2,(char) i))));
        }
        board.add(line);
        
        for(int i=0; i<4; i++){
            line = new ArrayList<>();
            for(int j=0; i<8; i++){
                line.add(new Square(null));
            }
            board.add(line);
        }
        
        //White pawns
        line = new ArrayList<>();
        for(int i = 97 ; i<= 104; i++){
            line.add(new Square(new Pawns(Color.WHITE, new Position(7,(char) i))));
        }
        board.add(line);
        
        //White pieces
        line = new ArrayList<>();
        line.add(new Square(rookW1));
        line.add(new Square(knightW1));
        line.add(new Square(bishopW1));
        line.add(new Square(queenW));
        line.add(new Square(kingW));
        line.add(new Square(bishopW2));
        line.add(new Square(knightW2));
        line.add(new Square(rookW2));
        board.add(line);       
    }
    
    public ChessBoard(ChessBoard board){
        this.board = (ArrayList<ArrayList<Square>>) board.getBoard().clone();
    }
    
    @Override
    public ChessBoard clone(){
        return new ChessBoard(this);
    }
    
    public void doMove(String move){
        
    }

    public ArrayList<ArrayList<Square>> getBoard() {
        return board;
    }

    Square getNeighbour(int x, int y, int xOffset, int yOffset) {
        int neighbourX = x + xOffset;
        int neighbourY = y + yOffset;
        Square ret = null;
        if ((neighbourX >= 0) && (neighbourX<SIZE) && (neighbourY>=0) && (neighbourY<SIZE)){
            ret = board.get(neighbourX).get(neighbourY);
        }
        return ret;
    }

}
