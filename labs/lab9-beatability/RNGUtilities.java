public class RNGUtilities {
    public static int seed;

    /**
     * Update the seed value to a new seed value.
     * This is important to allow consistent testing!
     *
     * @param newSeed
     */
    public static void seed(int newSeed) {
        seed = newSeed;
    }

    // Run one step of the random number generator
    public static int next() {
        seed = (65 * seed) % (65537);
        return seed;
    }

    public static int nextInt(int min, int max) {
        int range = (max - min);
        int val = next();
        val = val % range + min;
        return val;
    }

}
