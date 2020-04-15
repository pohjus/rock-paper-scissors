package fi.company;

public class RockPaperScissors {

    // Matrix for calculating who won.
    private Result[][]  whoWon = {{ Result.TIE,      Result.COMPUTER, Result.PLAYER },
                                  { Result.PLAYER,   Result.TIE,      Result.COMPUTER},
                                  { Result.COMPUTER, Result.PLAYER,   Result.TIE} };

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
            var userWeapon = Input.getInputUntilCorrect("Choose your Weapon");

            // Get computer's choice.
            var computerWeapon = ArtificialIntelligence.getWeapon();

            System.out.println("Computer chose " + computerWeapon);

            // Check who won
            Result whoWon = this.whoWon[ userWeapon.getValue() ][ computerWeapon.getValue() ];

            // Display who won (or tie).
            outputResult(whoWon);
        }

        outputVictory();
    }

    private void outputResult(Result result) {
        if(result == Result.COMPUTER) {
            computerWon++;
            System.out.println("Computer won!");
        } else if(result == Result.PLAYER) {
            playerWon++;
            System.out.println("Player won!");
        } else {
            System.out.println("Tie");
        }
    }

    private void outputVictory() {
        System.out.println("-".repeat(10));
        System.out.println("Computer won = " + computerWon + " times");
        System.out.println("Player   won = " + playerWon + " times");

        if(computerWon > playerWon) {
            System.out.println("Computer wins!");
        } else if (computerWon < playerWon){
            System.out.println("Player wins!");
        } else {
            System.out.println("It was a tie!");
        }
    }

}

