package fi.company;

import java.util.Scanner;

public class Input {
    private static Scanner myInput = new Scanner(System.in);

    public static Weapon getInput(String question) {
        boolean inValidInput = true;
        while(inValidInput) {
            System.out.println(question);
            String input = myInput.nextLine();
            if(input.equals("rock")) {
                return Weapon.ROCK;
            } else if(input.equals("paper")) {
                return Weapon.PAPER;
            } else if(input.equals("scissors")) {
                return Weapon.SCISSORS;
            }
        }

        return null;
    }
}
