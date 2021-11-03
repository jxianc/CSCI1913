import java.util.Random;

public class NumberGuesser extends Game {
    private int maxNumber;
    private int maxGuesses;
    private Random rng;
    private int secretNumber;
    private int playerGuesses;
    private boolean playerSuccess;  

    /**
     * constructor for NumberGuesser class
     * @param rng a Random class object to generate a random number
     * @param maxNumber maximum range for generating a random number (inclusive)
     * @param maxGuesses maximum number of player's guesses 
     */
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses) {
        this.rng = rng;
        this.maxNumber = maxNumber;
        this.maxGuesses = maxGuesses;
    }

    /**
     * a method that pick a random secret number, reset the game settings (playerGuesses, playerSuccess)
     * and return a starting message to user
     * @return a starting message
     */
    @Override
    protected String prepToPlay() {
        secretNumber = rng.nextInt(maxNumber) + 1;
        playerGuesses = 0;
        playerSuccess = false;
        return "I' ve picked a number 1 to " + maxNumber + ". You get " + maxGuesses + " guesses to guess it";
    }

    /**
     * a method that check the game is over or not
     * @return a boolean value shows that the game is over or not
     */
    @Override
    protected boolean isOver() {
        return maxGuesses == playerGuesses || playerSuccess;
    }

    /**
     * a method that validate player's move (check if input is a number)
     * @param move a string value of player's move
     * @return a boolean value shows that player's move is valid or not
     */
    @Override
    protected boolean isValid(String move) {
        if (move == null) return false;
        if (move.equals("quit")) return true;
        int playerNumber = 0;
        try {
            playerNumber = Integer.parseInt(move);
        } catch(Exception e) {
            return false;
        }
        return 1 <= playerNumber && playerNumber <= maxNumber;
    }

    /**
     * a method that convert player's move to integer and compare to secret number 
     * then show a message to indicate if player's guess was correct or too high or too low
     * @param move a string value of player's move
     * @return a string message to inform player 
     */
    @Override
    protected String processMove(String move) {
        int playerMove = Integer.parseInt(move);
        if (playerMove > secretNumber) {
            playerGuesses += 1;
            return "Too High";
        } else if (playerMove < secretNumber) {
            playerGuesses += 1;
            return "Too Low";
        } else {
            playerSuccess = true;
            return "That's it!";
        }
    }

    /**
     * a method that show a message indicate what was the secret number
     * @return a string message to inform player about the secret number
     */
    @Override
    protected String finalMessage() {
        return "The number was: " + secretNumber;
    }

    /**
     * a method that get the name of the game
     * @return name of the game
     */
    @Override
    public String getName() {
        return "Number Guesser";
    }
    
}
