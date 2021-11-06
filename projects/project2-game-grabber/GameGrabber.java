import java.util.Random;
import java.util.Scanner;

public class GameGrabber {
    private Game[] games;
    private Scanner user;

    /**
     * constructor for GameGrabber class 
     * @param games
     * @param user
     */
    GameGrabber(Game[] games, Scanner user) {
        this.games = games;
        this.user = user;
    }

    /**
     * method that show the game menu to user
     */
    public void showMenu() {
        for (int i=0; i<games.length; i++) {
            System.out.println(i + ") " + games[i].getName());
        }
        System.out.println(games.length + ") Quit");
    }

    /**
     * method that checks if the given string represents a valid move by checking if the move is a number
     * @param userInput a string representation of user's input
     * @return a boolean value of the given string is a valid input
     */
    public boolean isValid(String userInput) {
        if (userInput == null) return false;
        int userNumber = 0;
        try {
            userNumber = Integer.parseInt(userInput);
        } catch(Exception e) {
            return false;
        }
        return 0 <= userNumber && userNumber <= games.length;
    }

    /**
     *  method that allows the user to pick and play games until they choose to quit
     */
    public void doMenu() {
        while (true) {
            showMenu();
            String input;
            do {
                System.out.print("Pick a game (0-" + games.length + ") ");
                input = user.nextLine();
            } while (!isValid(input));
            int option = Integer.parseInt(input);
            if (option == games.length) {
                break;
            } else {
                games[option].play(user);
            }
        }
        System.out.println("goodbye");
    }
    
    public static void main(String[] args) {
        Random rng = new Random();
        WordsList words = new WordsList(rng);
        Hangman hm = new Hangman(words, 5, 15, 20);
        NumberGuesser ng = new NumberGuesser(rng, 1000, 10);
        RPS rps = new RPS(rng, 3, 3);
        WordJumble wj = new WordJumble(words, rng, 5, 15, 20);

        Game[] games = { hm, ng, rps, wj };
        Scanner user = new Scanner(System.in);
        GameGrabber gameGrabber = new GameGrabber(games, user);
        gameGrabber.doMenu();
    }
}
