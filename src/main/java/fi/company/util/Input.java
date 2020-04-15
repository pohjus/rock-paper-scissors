package fi.company.util;

import fi.company.data.Shape;

import java.util.Optional;
import java.util.Scanner;

/**
 * Handles user input.
 *
 * @author Jussi Pohjolainen
 */
public class Input {
    private static Scanner myInput = new Scanner(System.in);

    /**
     * Get's user input, must be "rock", "paper" or "scissors".
     *
     * If invalid value is given, user is prompted again.
     *
     * @param question The text to be outputted when asking input.
     * @param errorMsg The text to be outputted when giving invalid input.
     * @return User chosen shape.
     */
    public static Shape getInputUntilCorrect(String question, String errorMsg) {
        Optional<Shape> input;
        boolean invalidInput = false;

        do {
            input = getInput(question);
            invalidInput = input.isEmpty();
            if(invalidInput) {
                System.out.println(errorMsg);
            }
        } while(invalidInput);

        return input.get();
    }

    /**
     * Get's user input, must be "rock", "paper" or "scissors".
     *
     * @param question The text to be outputted when asking input.
     * @return Optional Shape, if user gives some other than rock, paper or scissors, empty Optional is returned.
     */
    public static Optional<Shape> getInput(String question) {
        System.out.println(question);
        var input = myInput.nextLine().toLowerCase();

        // Uses Java 14+ switch case
        return switch (input) {
            case "rock"     -> Optional.of(Shape.ROCK);
            case "paper"    -> Optional.of(Shape.PAPER);
            case "scissors" -> Optional.of(Shape.SCISSORS);
            default         -> Optional.empty();
        };
    }
}
