/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 * source : https://github.com/tseignette/8INF846-chess-ia
 */
import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class UCI {

    // ===============================================================================================
    // CONSTANTS
    // ===============================================================================================
    public static final String ENGINENAME = "ChessIA";
    public static final String AUTHOR = "Claire, Esther & Orann";

    // ===============================================================================================
    // ATTRIBUTES
    // ===============================================================================================
    private ChessBoard chessboard;
    private Agent ai;
    private int nbOfMoves = 0;

    // ===============================================================================================
    // PRIVATE METHODS
    // ===============================================================================================
    private void inputUCI() {
        System.out.println("id name " + ENGINENAME);
        System.out.println("id author " + AUTHOR);
        System.out.println("uciok");
    }

    private void setOptions(String input) {
        // Called when Arena sends options
    }

    private void isReady() {
        System.out.println("readyok");
    }

    private void newGame() {
        this.chessboard = new ChessBoard();
        this.ai = new Agent();
    }

    private void newPosition(String input) {
        input = input.substring(9).concat(" ");


        if (input.contains("moves")) {
            input = input.substring(input.indexOf("moves") + 6);
            int count = 0;
            while (input.length() > 0) {
                count++;
                if (count > this.nbOfMoves) {
                    //System.out.println("input" + input);
                    Move move = new Move(input.substring(0,4));
                    this.nbOfMoves++;
                    this.ai.getBelief().doMove(move);
                }
                input = input.substring(input.indexOf(' ') + 1);
            }

        }
        if (nbOfMoves==1) {
            System.out.println(Color.BLACK);
            ai.setColor(Color.BLACK);
        }
        else if(nbOfMoves == 0){
            System.out.println(Color.WHITE);
            ai.setColor(Color.WHITE);
        }
    }

    private void go() {
        Move bestMove = ai.minMax();
        String UCIMove = "0000";

        if (bestMove !=  null)
              UCIMove = bestMove.toString();
        System.out.println("bestmove " + UCIMove);
    }

    private void quit() {
        // Called when game is over
    }

    // ===============================================================================================
    // PUBLIC METHODS
    // ===============================================================================================
    public void listen() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.nextLine();

            if ("uci".equals(command)) {
                inputUCI();
            } else if (command.startsWith("setoption")) {
                setOptions(command);
            } else if ("isready".equals(command)) {
                isReady();
            } else if ("ucinewgame".equals(command)) {
                newGame();
            } else if (command.startsWith("position")) {
                newPosition(command);
            } else if (command.startsWith("go")) {
                go();
            } else if ("quit".equals(command)) {
                quit();
                break;
            }
        }
        input.close();
    }

}
