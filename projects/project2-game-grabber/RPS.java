import java.util.Random;

public class RPS extends Game {
    private Random rng;
    private int requiredWins;
    private int maxLosses;
    private String[] rps = {"rock", "paper", "scissors"};

    private int playerWins;
    private int AIWins;

    /**
     * constructor for RPS class
     * @param rng a Random class object to generate a random number
     * @param requiredWins number of turns a player has to win
     * @param maxLosses maximum number of turns a player has to loses 
     */
    public RPS(Random rng, int requiredWins, int maxLosses) {
        this.rng = rng;
        this.requiredWins = requiredWins;
        this.maxLosses = maxLosses;
    }

    /**
     * a method that resets the game settings (playerWins, AIWins)
     * and return a starting message to user
     * @return a starting message
     */
    @Override
    protected String prepToPlay() {
        playerWins = 0;
        AIWins = 0;
        return "Enter rock, paper, or scissors. Beat me in " + requiredWins + " times before I win " + maxLosses + " times!";
    }

    /**
     * a method that check the game is over or not
     * @return a boolean value shows that the game is over or not
     */
    @Override
    protected boolean isOver() {
        return playerWins == requiredWins || AIWins == maxLosses;
    }

    /**
     * a method that validate player's move (check if input is RPS option)
     * @param move a string value of player's move
     * @return a boolean value shows that player's move is valid or not
     */
    @Override
    protected boolean isValid(String move) {
        if (move == null) return false;
        if (move.equals("quit")) return true;
        for (int i=0; i<rps.length; i++) {
            if (move.equals(rps[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * a method that get a random choice of RPS to represent AI's move
     * @return a RPS option
     */
    private String getAIMove() {
        int randomIndex = rng.nextInt(3);
        return rps[randomIndex];
    }

    /**
     * a method that process player's move, evaluate if player wins the round
     * then show a message to indicate if player wins the round
     * @param move a string value of player's move
     * @return a string message to inform player 
     */
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

    /**
     * a method that show a message indicate if player wins the set
     * @return a string message to inform player if he wins the set
     */
    protected String finalMessage() {
        if (playerWins == requiredWins) {
            return "You win the set";
        } else {
            return "You lose the set";
        }
    }

    /**
     * a method that get the name of the game
     * @return name of the game
     */
    @Override
    public String getName() {
        return "Rock Paper Scissors";
    }

}
