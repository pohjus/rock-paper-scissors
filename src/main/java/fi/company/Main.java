package fi.company;

/**
 * Starting point of the app.
 *
 * @author Jussi Pohjolainen
 */
public class Main {
    /**
     * main - method.
     *
     * @param args not used.
     */
    public static void main(String [] args) {
        // Start the game with rounds of 3.
        new RockPaperScissors(3).playGame();
    }
}