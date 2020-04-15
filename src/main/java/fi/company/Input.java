package fi.company;

import java.util.Scanner;

public class Input {
    private static Scanner myInput = new Scanner(System.in);

    public static Weapon getInput(String question) {
        boolean inValidInput = true;
        while(inValidInput) {
            System.out.println(question);
            String input = myInput.nextLine();
            if(input.equalsIgnoreCase("rock")) {
                return Weapon.ROCK;
            } else if(input.equalsIgnoreCase("paper")) {
                return Weapon.PAPER;
            } else if(input.equalsIgnoreCase("scissors")) {
                return Weapon.SCISSORS;
            }
        }

        return null;
    }
}
