package fi.company;

import java.util.Optional;
import java.util.Scanner;

public class Input {
    private static Scanner myInput = new Scanner(System.in);

    public static Weapon getInputUntilCorrect(String question) {
        Optional<Weapon> input = null;

        do {
            input = getInput(question);
        } while(input.isEmpty());

        return input.get();
    }

    public static Optional<Weapon> getInput(String question) {
        System.out.println(question);
        var input = myInput.nextLine().toLowerCase();

        return switch (input) {
            case "rock" -> Optional.of(Weapon.ROCK);
            case "paper" -> Optional.of(Weapon.PAPER);
            case "scissors" -> Optional.of(Weapon.SCISSORS);
            default -> Optional.empty();
        };
    }
}
