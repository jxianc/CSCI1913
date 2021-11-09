public class BeatabilityEstimatorStringTest {

    public static void main(String[] args) {
        RNGUtilities.seed(55);
        RandomGenerator<String> rg = new WordGenerator();
        double n = BeatabilityEstimator.estimate("", rg, 1000);
        System.out.println(n); // 1.0 -- every word is "bigger" than the empty string

        RNGUtilities.seed(43);
        n = BeatabilityEstimator.estimate("ape", rg, 1000);
        System.out.println(n); // 0.982 -- most words are "bigger" than ape (a is early in the alphabet)

        RNGUtilities.seed(919);
        n = BeatabilityEstimator.estimate("zebra", rg, 1000);
        System.out.println(n); // 0.0 -- no words are "bigger" than zebra in our word list

        RNGUtilities.seed(19);
        n = BeatabilityEstimator.estimate("water", rg, 1000);
        System.out.println(n); // 0.036 -- few words are "bigger" than water (later in the alphabet)

        RNGUtilities.seed(19);
        n = BeatabilityEstimator.estimate("groovy", rg, 1000);
        System.out.println(n); // 0.624 -- groovy is pretty close to the middle of our words list.
    }
}

// Correct output:
// 1.0
// 0.982
// 0.0
// 0.036
// 0.624
