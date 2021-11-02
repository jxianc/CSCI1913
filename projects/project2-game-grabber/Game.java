import java.util.Scanner;

public abstract class Game {
    protected abstract String prepToPlay();
    protected abstract boolean isOver();
    protected abstract boolean isValid(String move);
    protected abstract String processMove(String move);
    protected abstract String finalMessage();
    public abstract String getName();

    public void play(Scanner user) {
        String initialMessage = prepToPlay();
        System.out.println(initialMessage);
        while(!isOver()) {
            System.out.print("Enter Your Move or ’quit ’ to quit > ");
            String move = user.nextLine();
            if (move.equals("quit")) break;
            while (!isValid(move)) {
                System.out.print("Invalid Move! try again > ");
                move = user.nextLine();
            }
            String response = processMove(move);
            System.out.println(response);
        }
        String finalMessage = finalMessage();
        System.out.println(finalMessage);
        
    }
}