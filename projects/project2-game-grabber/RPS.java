import java.util.Random;

public class RPS extends Game {
    private Random rng;
    private int requiredWins;
    private int maxLosses;
    private String[] rps = {"rock", "paper", "scissors"};

    private int playerWins;
    private int AIWins;

    public RPS(Random rng, int requiredWins, int maxLosses) {
        this.rng = rng;
        this.requiredWins = requiredWins;
        this.maxLosses = maxLosses;
    }

    @Override
    protected String prepToPlay() {
        playerWins = 0;
        AIWins = 0;
        return "Enter rock, paper, or scissors. Beat me in " + requiredWins + " times before I win " + maxLosses + " times!";
    }

    @Override
    protected boolean isOver() {
        return playerWins == requiredWins || AIWins == maxLosses;
    }


    @Override
    protected boolean isValid(String move) {
        boolean moveIsValid = false;
        for (int i=0; i<rps.length; i++) {
            if (move.equals(rps[i])) {
                moveIsValid = true;
            }
        }
        return moveIsValid;
    }

    private String getAIMove() {
        int randomIndex = rng.nextInt(3);
        return rps[randomIndex];
    }

    @Override
    protected String processMove(String move) {
        String AIMove = getAIMove();
        String vs = AIMove + " vs. " + move;
        if (move.equals("rock")) {
            if (AIMove.equals("scissors")) {
                playerWins += 1;
                return vs + " you Win";
            } else if (AIMove.equals("paper")) {
                AIWins += 1;
                return vs + " you lose";
            }
        } else if (move.equals("paper")) {
            if (AIMove.equals("rock")) {
                playerWins += 1;
                return vs + " you Win";
            } else if (AIMove.equals("scissors")) {
                AIWins += 1;
                return vs + " you lose";
            }
        } else {
            if (AIMove.equals("paper")) {
                playerWins += 1;
                return vs + " you Win";
            } else if (AIMove.equals("rock")) {
                AIWins += 1;
                return vs + " you lose";
            }
        }
        return vs + " we Tie";
    }

    protected String finalMessage() {
        if (playerWins > AIWins) {
            return "You win the set";
        } else {
            return "You lose the set";
        }
    }

    @Override
    public String getName() {
        return "Rock Paper Scissors";
    }

}
