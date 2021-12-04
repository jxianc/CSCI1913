// Jingxian Chai

public class BeatabilityEstimator {
    /**
     * method that estimate the beatability
     * @param <T> type parameter 
     * @param t object of the parameterized type that is comparable to itself
     * @param rg an instance of a class T implements RandomGenerator
     * @param trials number of trials to compare
     * @return an estimated beatability 
     */
    public static <T extends Comparable<T>> double estimate(T t, RandomGenerator<T> rg, int trials) {
        int count = 0;
        for (int i=0; i<trials; i++) {
            T randomT = rg.get();
            count += randomT.compareTo(t) > 0 ? 1 : 0;
        }
        return (double) count / trials;
    }
}
