public class BeatabilityEstimatorCardTest {

    public static void main(String[] args) {
        RNGUtilities.seed(55);
        RandomGenerator<Hand> rg = new DeckOfCards();
        double n = BeatabilityEstimator.estimate(new Hand(1, 1, 1), rg, 10);
        // lowest possible hand, the only way to not beat it is to go bust
        System.out.println(n); // 0.5
        // oh dear -- about half of randomly drawn hands go bust. A most dire game.

        RNGUtilities.seed(43);
        n = BeatabilityEstimator.estimate(new Hand(10, 10, 1), rg, 500);
        // 21, this hand cannot be beat
        System.out.println(n); // 0.0

        RNGUtilities.seed(919);
        n = BeatabilityEstimator.estimate(new Hand(8, 10, 1), rg, 500);
        // 20 -- a good hand.
        System.out.println(n); // 0.122

        RNGUtilities.seed(19);
        n = BeatabilityEstimator.estimate(new Hand(8, 1, 1), rg, 500);
        System.out.println(n); // 0.44

        RNGUtilities.seed(555);
        n = BeatabilityEstimator.estimate(new Hand(5, 5, 5), rg, 500);
        System.out.println(n); // 0.32

        RNGUtilities.seed(19);
        n = BeatabilityEstimator.estimate(new Hand(14, 11, 1), rg, 500);
        // this hand is bust by default -- easy to beat.
        System.out.println(n); // 0.486

        RNGUtilities.seed(19);
        n = BeatabilityEstimator.estimate(new Hand(7, 7, 8), rg, 500);
        // this hand is also bust, it should be EXACTLY as defeatable
        System.out.println(n); // 0.486
    }
}

// Correct output:
// 0.5
// 0.0
// 0.122
// 0.44
// 0.32
// 0.486
// 0.486
