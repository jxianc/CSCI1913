import java.util.Random;

public class RPS extends Game {
    private Random rng;
    private int requiredWins;  
    private int maxLosses;
    private String[] rps = {"rock", "paper", "scissors"};
    private int userWins;
    private int AIWins;

    /**
     * constructor for RPS class
     * @param rng a Random class object to generate a random number
     * @param requiredWins number of turns a user has to win
     * @param maxLosses maximum number of turns a user has to loses 
     */
    public RPS(Random rng, int requiredWins, int maxLosses) {
        this.rng = rng;
        this.requiredWins = requiredWins;
        this.maxLosses = maxLosses;
    }

    /**
     * method that resets the game settings (userWins, AIWins)
     * and return a starting message to user
     * @return a starting message
     */
    @Override
    protected String prepToPlay() {
        userWins = 0;
        AIWins = 0;
        return "Enter rock, paper, or scissors. Beat me in " + requiredWins + " times before I win " + maxLosses + " times!";
    }

    /**
     * method that checks if the current state of the game is done (win or lose)
     * @return a boolean value of the current game is over
     */
    @Override
    protected boolean isOver() {
        return userWins == requiredWins || AIWins == maxLosses;
    }

    /**
     * method that checks if the given string represents a valid move by checking if the move is a RPS option
     * @param move a string representation of user's move
     * @return a boolean value of the given string is a valid move
     */
    @Override
    protected boolean isValid(String move) {
        if (move == null) return false;
        if (move.equals("quit")) return true;
        for (String option: rps) {
            if (move.equals(option)) {
                return true;
            }
        }
        return false;
    }

    /**
     * method that get a random choice of RPS to represent AI's move
     * @return a RPS option
     */
    private String getAIMove() {
        int randomIndex = rng.nextInt(3);
        return rps[randomIndex];
    }

    /**
     * method that takes a valid move and updates the game state based on the user’s move
     * then return a update message to indicate if the user wins the round
     * @param move a string representation of user's move
     * @return a update message for user (you win/you lose/we tie)
     */
    @Override
    protected String processMove(String move) {
        String AIMove = getAIMove();
        String vs = AIMove + " vs. " + move;
        if (move.equals("rock")) {
            if (AIMove.equals("scissors")) {
                userWins += 1;
                return vs + " you Win";
            } else if (AIMove.equals("paper")) {
                AIWins += 1;
                return vs + " you lose";
            }
        } else if (move.equals("paper")) {
            if (AIMove.equals("rock")) {
                userWins += 1;
                return vs + " you Win";
            } else if (AIMove.equals("scissors")) {
                AIWins += 1;
                return vs + " you lose";
            }
        } else {
            if (AIMove.equals("paper")) {
                userWins += 1;
                return vs + " you Win";
            } else if (AIMove.equals("rock")) {
                AIWins += 1;
                return vs + " you lose";
            }
        }
        return vs + " we Tie";
    }

    /**
     * method that returns a final message to user
     * @return a final message to inform user if he wins the set
     */
    protected String finalMessage() {
        if (userWins == requiredWins) {
            return "You win the set";
        } else {
            return "You lose the set";
        }
    }

    /**
     * method that get the name of the game
     * @return name of the game
     */
    @Override
    public String getName() {
        return "Rock Paper Scissors";
    }

}
