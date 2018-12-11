package project;

import java.util.ArrayList;
import project.pieces.Piece;

/**
 *
 * @author Claire, Esther, Orann
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UCI listener = new UCI();
        listener.listen(); 
        
        /*
        ChessBoard board = new ChessBoard();
        
        System.out.println(board);        
        
        ArrayList<ArrayList<Square>> myBoard = board.getBoard();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Piece p = myBoard.get(i).get(j).getPiece();
                if(p != null){
                    System.out.print(p);
                    System.out.println(myBoard.get(i).get(j).getPiece().getPossibleMoves(board));
                }
            }
        }
        */

    }
    
}
