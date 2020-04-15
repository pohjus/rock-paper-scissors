package fi.company;

import fi.company.data.Winner;
import fi.company.util.ArtificialIntelligence;
import fi.company.util.Input;

public class RockPaperScissors {

    // Matrix for calculating who won.
    private Winner[][]  whoWon = {{ Winner.TIE,      Winner.COMPUTER, Winner.PLAYER },
                                  { Winner.PLAYER,   Winner.TIE,      Winner.COMPUTER},
                                  { Winner.COMPUTER, Winner.PLAYER,   Winner.TIE} };

    // How many times computer won.
    private int computerWon;

    // How many times player won.
    private int playerWon;

    // number of rounds.
    private int rounds;

    public void setRounds(int rounds) {
        if(rounds >= 3) {
            this.rounds = rounds;
        } else {
            throw new IllegalArgumentException("Rounds must be >= 3");
        }
    }

    public RockPaperScissors(int rounds) {
        setRounds(rounds);
    }


    public void playGame() {
        for(int i=0; i<rounds; i++) {

            // Ask user's choice, if incorrect value, will be asked again.
            var userWeapon = Input.getInputUntilCorrect("Choose your shape (rock, paper, scissors):", "Wrong input.");

            // Get computer's choice.
            var computerWeapon = ArtificialIntelligence.getWeapon();

            System.out.println("Computer chose " + computerWeapon);

            // Check who won
            var whoWon = this.whoWon[ userWeapon.getValue() ][ computerWeapon.getValue() ];

            // Display who won (or tie).
            outputResult(whoWon);
        }

        outputVictory();
    }

    private void outputResult(Winner result) {
        if(result == Winner.COMPUTER) {
            computerWon++;
            System.out.println("Computer won!");
        } else if(result == Winner.PLAYER) {
            playerWon++;
            System.out.println("Player won!");
        } else {
            System.out.println("Tie");
        }
    }

    private void outputVictory() {
        // Uses textblocks preview feature, Java 14+
        var output = """
                     ------------------------------
                     RESULT, best of %s
                     ------------------------------
                     Computer won %s times
                     Player   won %s times
                     """.formatted(rounds, computerWon, playerWon);

        System.out.println(output);

        if(computerWon > playerWon) {
            System.out.println("Computer wins!");
        } else if (computerWon < playerWon){
            System.out.println("Player wins!");
        } else {
            System.out.println("It was a tie!");
        }
    }

}

