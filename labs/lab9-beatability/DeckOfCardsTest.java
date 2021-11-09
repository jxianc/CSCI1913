import java.util.Arrays;

public class DeckOfCardsTest {

    // Tests: all results should be true
    public static void main(String[] args) {
        RNGUtilities.seed(7841);
        DeckOfCards doc = new DeckOfCards();
        Hand h = doc.get();
        System.out.println(Arrays.toString(h.getAsIntArray())); // [12, 9, 7]

        RNGUtilities.seed(23);
        doc = new DeckOfCards();
        h = doc.get();
        System.out.println(Arrays.toString(h.getAsIntArray())); // [1, 10, 7]

        // Tests that make sure the inheritance structure is as expected.
        System.out.println(doc instanceof RandomGenerator); // true
        // the following code should compile and run correctly.
        RandomGenerator<Hand> rg = doc;
        System.out.println(Arrays.toString(rg.get().getAsIntArray())); // [9, 10, 11]
    }
}

// Correct output:
// [12, 9, 7]
// [1, 10, 7]
// true
// [9, 10, 11]
