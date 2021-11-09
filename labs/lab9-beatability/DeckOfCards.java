public class DeckOfCards implements RandomGenerator<Hand> {
    /**
     * method tha return a random hand with three randomly chosen cards from 1 to 13 (inclusive)
     * @return an object of hand class
     */
    @Override
    public Hand get() {
        int card0 = RNGUtilities.nextInt(1, 14);
        int card1 = RNGUtilities.nextInt(1, 14);
        int card2 = RNGUtilities.nextInt(1, 14);
        Hand h = new Hand(card0, card1, card2);
        return h;
    }
}
