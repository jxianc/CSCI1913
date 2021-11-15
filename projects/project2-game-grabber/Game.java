// Jingxian Chai

import java.util.Scanner;

/**
 * Games class is an abstract class, represents the main structure of a game
 */
public abstract class Game {
    /**
     * method that updates the state of the object to be the beginning of a new game
     * and return a starting message to user
     * @return a starting message
     */
    protected abstract String prepToPlay();

    /**
     * method that checks if the current state of the game is done (win or lose)
     * @return a boolean value of the current game is over
     */
    protected abstract boolean isOver();

    /**
     * method that checks if the given string represents a valid move
     * @param move a string representation of user's move
     * @return a boolean value of the given string is a valid move
     */
    protected abstract boolean isValid(String move);

    /**
     * method that takes a valid move and updates the game state based on the user’s move
     * @param move a string representation of user's move
     * @return a update message for user 
     */
    protected abstract String processMove(String move);

    /**
     * method that returns a final message to user
     * @return a final message
     */
    protected abstract String finalMessage();

    /**
     * method that returns the name of the game
     * @return name of the game
     */
    public abstract String getName();

    /**
     * method that run the game by the above abstract method
     * @param user a scanner object for interacting with the user
     */
    public void play(Scanner user) {
        String initialMessage = prepToPlay();
        System.out.println(initialMessage);
        while(!isOver()) {
            System.out.print("Enter Your Move or 'quit' to quit> ");
            String move = user.nextLine();
            while (!isValid(move)) {
                System.out.print("Invalid Move! try again> ");
                move = user.nextLine();
            }
            if (move.equals("quit")) break;
            String response = processMove(move);
            if (response != null) {
                System.out.println(response);
            }
        }
        String finalMessage = finalMessage();
        System.out.println(finalMessage);   
    }
}