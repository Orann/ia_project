package project;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Square {
    private Piece piece;

    public Square(Piece piece) {
        this.piece = piece;
    }
    
    public boolean isEmpty(){
        return (this.piece == null);
    }    
}