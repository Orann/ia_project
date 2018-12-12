/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author clair
 */
public class Move {
    private Position from;
    private Position to;

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
    }
    
    public Move(String s){
        System.out.println("new move : " + s);
        from = new Position(Integer.parseInt(s.substring(1,2)),s.charAt(0));
        to = new Position(Integer.parseInt(s.substring(3,4)),s.charAt(2));
        
    }

    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }

    @Override
    public String toString() {
        return ""+from + to;
    }
    
    
}
