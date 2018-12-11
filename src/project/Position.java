package project;

/**
 *
 * @author Claire, Esther & Orann
 */
public class Position extends Object {
    private int x;
    private char y;

    /**
     * Constructor with the abscissa and the ordonate
     *
     * @param x
     * @param y
     */
    public Position(int x, char y) {
        this.x = x;        
        this.y = y;
    }

    /**
     * Constructor with a position
     *
     * @param p
     */
    public Position(Position p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * Getter
     *
     * @return the abscissa of the position
     */
    public int getX() {
        return x;
    }
    
    /**
     * Getter
     * @return the ordinate of the position in letter
     */
    public char getY() {
        return y;
    }

    @Override
    public String toString() {
        return ""+y+x;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    
    
}
