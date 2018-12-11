package project;

/**
 *
 * @author Claire, Esther & Orann
 */
public enum Color {
    WHITE("W"),
    BLACK("B");

    private String name = "";

    Color(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }    
}
