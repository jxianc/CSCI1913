import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);
        Random rng = new Random();
        NumberGuesser ng = new NumberGuesser(rng, 10, 5);
        ng.play(playerInput);
        // RPS rps = new RPS(rng, 3, 3);
        // rps.play(playerInput);
    }
}