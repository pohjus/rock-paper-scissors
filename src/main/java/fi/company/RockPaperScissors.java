package fi.company;

import fi.company.data.Winner;
import fi.company.util.ArtificialIntelligence;
import fi.company.util.Input;

import java.util.List;

/**
 * Main controller for the game.
 *
 * @author Jussi Pohjolainen
 */
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


    /**
     * Set the round number to be played. Must be >= 3.
     *
     * @param rounds number of rounds.
     * @throws IllegalArgumentException if rounds < 3.
     */
    private void setRounds(int rounds) throws IllegalArgumentException {
        if(rounds >= 3) {
            this.rounds = rounds;
        } else {
            throw new IllegalArgumentException("Rounds must be >= 3");
        }
    }

    /**
     * Initializes the game with the number of rounds.
     *
     * @param rounds number of rounds.
     * @throws IllegalArgumentException if rounds < 3.
     */
    public RockPaperScissors(int rounds) throws IllegalArgumentException {
        setRounds(rounds);
    }


    /**
     * Starts the game.
     */
    public void playGame() {
        for(int i=0; i<rounds; i++) {

            // Ask user's choice, if incorrect value, will be asked again.
            var userWeapon = Input.getInputUntilCorrect("Choose your shape (rock, paper, scissors):",
                    "Wrong input.");

            // Get computer's choice.
            var computerWeapon = ArtificialIntelligence.getWeapon();

            System.out.println("Computer chose " + computerWeapon);

            // Check who won
            var whoWon = this.whoWon[ userWeapon.getValue() ][ computerWeapon.getValue() ];

            // Output who won
            System.out.println(whoWon + " won");

            // Increment scores for player or computer
            incrementScores(whoWon);
        }

        // Output final scores
        outputScores();
    }

    /**
     * Increment scores for the winner.
     *
     * @param winner who won.
     */
    private void incrementScores(Winner winner) {
        // Uses enhanced switch case
        switch(winner) {
            case COMPUTER -> computerWon++;
            case PLAYER   -> playerWon++;
        }
    }

    /**
     * Outputs who won.
     */
    private void outputScores() {
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

