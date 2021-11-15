// Jingxian Chai

/**
 * This class implement the game called "Hangman",
 * the game will choose a secret word and show the word length, by displaying a series of blank,
 * user can guesses a letter each time, if the user guesses a letter that is in the word, the letter will be revealed.
 * User will be given a maximum number of guesses they are allowed to guess.
 */
public class Hangman extends Game {
    private WordsList words;
    private int minWordLen;
    private int maxWordLen;
    private int maxGuesses;
    private String secretWord;
    private String hint;
    private int userGuesses;
    private int userRightGuesses;

    /**
     * constructor for Hangman class
     * @param words an object of WordsList class
     * @param minWordLen minimum length of word (inclusive)
     * @param maxWordLen maximum length of word (inclusive)
     * @param maxGuesses maximum number of user's guesses
     */
    public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses) {
        this.words = words;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
    }

    /**
     * method that picks a random secret word and resets the game settings (hint, userGuesses, userRightGuesses)
     * and return a starting message to user
     * @return a starting message
     */
    @Override
    protected String prepToPlay() {
        secretWord = words.getWord(minWordLen, maxWordLen);
        hint = "_";
        hint = hint.repeat(secretWord.length());
        userGuesses = 0;
        userRightGuesses = 0;
        return "I've picked a " + secretWord.length() + " letter word. Guess letters you think are in the word. You get " + maxGuesses + " guesses.";
    }

    /**
     * method that checks if the current state of the game is done (win or lose)
     * @return a boolean value of the current game is over
     */
    @Override
    protected boolean isOver() {
        return maxGuesses == userGuesses || userRightGuesses == secretWord.length();
    }

    /**
     * method that checks if the given string represents a valid move by checking if the move is a single character
     * @param move a string representation of user's move
     * @return a boolean value of the given string is a valid move
     */
    @Override
    protected boolean isValid(String move) {
        if (move == null) return false;
        if (move.equals("quit")) return true;
        return move.length() == 1 && Character.isLetter(move.charAt(0));
    }

    /**
     * method that update the current hint by replacing the given index of character with the given character
     * @param index an index of the hint needed to update
     * @param move a character needed to replace with
     */
    private void updateHint(int index, String move) {
        hint = hint.substring(0, index) + move + hint.substring(index+1);
        userRightGuesses += 1;
    }

    /**
     * method that takes a valid move and updates the game state based on the user’s move
     * then return a update message to indicate if user's guess was correct
     * @param move a string representation of user's move
     * @return a update message for user (hint)
     */
    @Override
    protected String processMove(String move) {
        if (secretWord.contains(move) && !hint.contains(move)) {
            int index = -1;
            do {
                index = secretWord.indexOf(move, index + 1);
                if (index != -1) {
                    updateHint(index, move);
                }
            } while (index != -1);
        }
        userGuesses += 1;
        return hint;
    }

    /**
     * method that returns a final message to user
     * @return a final message to inform user what was the secret word
     */
    @Override
    protected String finalMessage() {
        return "The word was: " + secretWord;
    }

    /**
     * method that get the name of the game
     * @return name of the game
     */
    @Override
    public String getName() {
        return "Hangman";
    }
}
