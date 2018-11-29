package project;

/**
 *
 * @author Claire, Esther & Orann
 */
public enum Color {
    WHITE("White"),
    BLACK("Black");

    private String name = "";

    Color(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }    
}
