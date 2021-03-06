// Jingxian Chai

import java.util.Random;

/**
 * This class implements a number guessing game,
 * the game will choose a secret number, and show the range to user,
 * user can guesses a number each time, if user guesses the right number, the user wins,
 * else the user will be informed if the number is too high or too low.
 * User will be given a maximum number of guesses they are allowed to guess
 */
public class NumberGuesser extends Game {
    private int maxNumber;
    private int maxGuesses;
    private Random rng;
    private int secretNumber;
    private int userGuesses;
    private int userNumber;

    /**
     * constructor for NumberGuesser class
     * @param rng a Random class object to generate a random number
     * @param maxNumber maximum range for generating a random number (inclusive)
     * @param maxGuesses maximum number of user's guesses 
     */
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses) {
        this.rng = rng;
        this.maxNumber = maxNumber;
        this.maxGuesses = maxGuesses;
    }

    /**
     * method that picks a random secret number and resets the game settings (userGuesses)
     * and return a starting message to user
     * @return a starting message
     */
    @Override
    protected String prepToPlay() {
        secretNumber = rng.nextInt(maxNumber) + 1;
        userNumber = 0;
        userGuesses = 0;
        return "I've picked a number 1 to " + maxNumber + ". You get " + maxGuesses + " guesses to guess it";
    }

    /**
     * method that checks if the current state of the game is done (win or lose)
     * @return a boolean value of the current game is over
     */
    @Override
    protected boolean isOver() {
        return maxGuesses == userGuesses || userNumber == secretNumber;
    }

    /**
     * method that checks if the given string represents a valid move by checking if the move is a number
     * @param move a string representation of user's move
     * @return a boolean value of the given string is a valid move
     */
    @Override
    protected boolean isValid(String move) {
        if (move == null) return false;
        if (move.equals("quit")) return true;
        int userNumber = 0;
        try {
            userNumber = Integer.parseInt(move);
        } catch(Exception e) {
            return false;
        }
        return 1 <= userNumber && userNumber <= maxNumber;
    }

    /**
     * method that takes a valid move and updates the game state based on the user???s move
     * then return a update message to indicate if user's guess was correct or too high or too low
     * @param move a string representation of user's move
     * @return a update message for user (too high, too low, that's it)
     */
    @Override
    protected String processMove(String move) {
        userNumber = Integer.parseInt(move);
        if (userNumber > secretNumber) {
            userGuesses += 1;
            return "Too High";
        } else if (userNumber < secretNumber) {
            userGuesses += 1;
            return "Too Low";
        } else {
            return "That's it!";
        }
    }

    /**
     * method that returns a final message to user
     * @return a final message to inform user what was the secret number
     */
    @Override
    protected String finalMessage() {
        return "The number was: " + secretNumber;
    }

    /**
     * method that get the name of the game
     * @return name of the game
     */
    @Override
    public String getName() {
        return "Number Guesser";
    }
    
}
