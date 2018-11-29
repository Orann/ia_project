package project;

import java.util.ArrayList;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Environment {
    private ArrayList<ArrayList<Square>> chessboard;

    public Environment() {
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
        
        chessboard = new ArrayList<>();
        
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
        chessboard.add(line);
        
        //Black pawns
        line = new ArrayList<>();
        for(int i = 97 ; i<= 104; i++){
            line.add(new Square(new Pawns(Color.BLACK, new Position(2,(char) i))));
        }
        chessboard.add(line);
        
        for(int i=0; i<4; i++){
            line = new ArrayList<>();
            for(int j=0; i<8; i++){
                line.add(new Square(null));
            }
            chessboard.add(line);
        }
        
        //White pawns
        line = new ArrayList<>();
        for(int i = 97 ; i<= 104; i++){
            line.add(new Square(new Pawns(Color.WHITE, new Position(7,(char) i))));
        }
        chessboard.add(line);
        
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
        chessboard.add(line);       
    }
    
    
}
