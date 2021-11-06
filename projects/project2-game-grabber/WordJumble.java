import java.util.Random;

public class WordJumble extends Game {
    private WordsList wl;
    private Random rng;
    private int minWordLen;
    private int maxWordLen;
    private int maxGuesses;
    private String secretWord;
    private String jumbledWord;
    private int userGuesses;
    private boolean userSuccess;

    /**
     * constructor for WordJumble class
     * @param wl an object of WordsList class
     * @param rng an object of Random class
     * @param minWordLen minimum length of word (inclusive)
     * @param maxWordLen maximum length of word (inclusive)
     * @param maxGuesses maximum number of user's guesses
     */
    public WordJumble(WordsList wl, Random rng, int minWordLen, int maxWordLen, int maxGuesses) {
        this.wl = wl;
        this.rng = rng;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
    }

    private void jumble() {
        char[] charArray = secretWord.toCharArray();
        for (int i=charArray.length-1; i>=0; i--) {
            int j = rng.nextInt(i+1);
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        jumbledWord = String.valueOf(charArray);
    }

    /**
     * method that picks a random secret word and resets the game settings (userGuesses, userSuccess)
     * and return a starting message to user
     * @return a starting message
     */
    @Override
    protected String prepToPlay() {
        secretWord = wl.getWord(minWordLen, maxWordLen);
        jumble();
        userGuesses = 0;
        userSuccess = false;
        return "The following is a jumbled up word: " + jumbledWord + " You get " + maxGuesses + " guesses to guess it";
    }

    /**
     * method that checks if the current state of the game is done (win or lose)
     * @return a boolean value of the current game is over
     */
    @Override
    protected boolean isOver() {
        return userGuesses == maxGuesses || userSuccess;
    }

    /**
     * method that checks if the given string represents a valid move, every input is valid in this game 
     * @param move a string representation of user's move
     * @return a boolean value of the given string is a valid move
     */
    @Override
    protected boolean isValid(String move) {
        if (move == null) return false;
        return true;
    }

    /**
     * method that takes a valid move and updates the game state based on the user’s move
     * then return a update message to indicate if user's guess was correct
     * @param move a string representation of user's move
     * @return a update message for user 
     */
    @Override
    protected String processMove(String move) {
        if (move.equals(secretWord)) {
            userSuccess = true;
            return null;
        } else {
            userGuesses += 1;
            return "That's not it";
        }
    }

    /**
     * method that returns a final message to user
     * @return a final message to inform user what was the secret word
     */
    @Override
    protected String finalMessage() {
        return "The word was " + secretWord;
    }

    /**
     * method that get the name of the game
     * @return name of the game
     */
    @Override
    public String getName() {
        return "Word Jumble";
    }
}
