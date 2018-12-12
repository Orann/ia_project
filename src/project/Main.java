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
        Agent ai = new Agent();
        Move m = ai.minMax();
        System.out.println(m);
        System.out.println(ai.getBelief());
        ai.getBelief().doMove(m);
        //ai.getBelief().doMove(new Move("c2c3"));
        System.out.println(ai.getBelief());
        System.out.println(ai.getAllPossibleMoves(true, ai.getBelief()));
        System.out.println(ai.minMax());
        */
    }
    
}
