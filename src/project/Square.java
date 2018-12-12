package project;

import java.io.Serializable;
import project.pieces.Piece;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Square  implements Serializable {
    private Piece piece;

    public Square(Piece piece) {
        this.piece = piece;
    }
    
    public boolean isEmpty(){
        return (this.piece == null);
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return piece.toString();
    }   

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    
}
