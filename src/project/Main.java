package project;

import ucichess.ChessBoard;
import ucichess.UCIChess;
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

    }
    
}
