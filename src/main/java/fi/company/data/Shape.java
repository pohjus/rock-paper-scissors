package fi.company.data;

/**
 * Enume presenting the shapes (rock, paper scissors).
 *
 * @author Jussi Pohjolainen
 */
public enum Shape {
    ROCK(0), PAPER(1), SCISSORS(2);

    private final int value;

    private Shape(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
