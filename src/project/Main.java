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
        UCIChess uci=new UCIChess("/home/orann/Téléchargements/arena_chess/Arena_x86_64_linux");
        int titou = 2;
        System.out.println(uci.get_UciOk(false));        
        System.out.println("Titou");
        //uci.go_Think(); //calculate white move
        //make the move
        System.out.println(uci.get_ReadyOk(false)); //wait for engine be ready
        uci.move_FromSTART("e2e4", false);
        //make the move

    }
    
}
