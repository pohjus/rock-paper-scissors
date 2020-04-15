package fi.company.util;

import fi.company.data.Shape;

import java.util.Optional;
import java.util.Scanner;

public class Input {
    private static Scanner myInput = new Scanner(System.in);

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
