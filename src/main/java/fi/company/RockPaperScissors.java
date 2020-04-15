package fi.company;

import javax.management.relation.RelationSupport;

public class RockPaperScissors {
    private int computerWon;
    private int playerWon;

    private int rounds;

    public RockPaperScissors(int rounds) {
        this.rounds = rounds;
    }
    // Matrix for whowon
    private Result[][]  whoWon = {{Result.TIE, Result.COMPUTER, Result.PLAYER},
            {Result.PLAYER, Result.TIE, Result.COMPUTER},
            {Result.COMPUTER, Result.PLAYER, Result.TIE}};

    public void playGame() {
        for(int i=0; i<rounds; i++) {
            // Ask user input
            var userWeapon = Input.getInput("Choose your Weapon");

            // Calculate computer input
            var computerWeapon = ArtificialIntelligence.getWeapon();

            System.out.println("Computer chose " + computerWeapon);
            // Check who won
            Result whoWon = this.whoWon[userWeapon.getValue()][computerWeapon.getValue()];

            // Display victory or tie
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
        if(computerWon > playerWon) {
            System.out.println("Computer wins!");
        } else if (playerWon < computerWon){
            System.out.println("Player wins!");
        } else {
            System.out.println("It was a tie!");
        }
    }

}

