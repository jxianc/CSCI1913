public class BeatabilityEstimator {
    /**
     * method that estimate the beatability
     * @param <T> type 
     * @param d object of the parameterized type that is comparable to itself
     * @param rg an instance of a class T implements RandomGenerator
     * @param trials number of trials to compare
     * @return an estimated beatability 
     */
    public static <T extends Comparable<T>> double estimate(T d, RandomGenerator<T> rg, int trials) {
        int count = 0;
        for (int i=0; i<trials; i++) {
            T randomWord = rg.get();
            if (randomWord.compareTo(d) > 0) {
                count += 1;
            }
        }
        return (double) count / trials;
    }
}
