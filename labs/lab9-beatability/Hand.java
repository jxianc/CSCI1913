// Jingxian Chai

public class Hand implements Comparable<Hand> {
    private int card0;
    private int card1;
    private int card2;

    /**
     * constructor for class Hand
     * @param card0 first card
     * @param card1 second card
     * @param card2 third card
     */
    public Hand(int card0, int card1, int card2) {
        this.card0 = card0;
        this.card1 = card1;
        this.card2 = card2;
    }

    /**
     * method that returns hand of cards
     * @return hand of cards in an array representation
     */
    public int[] getAsIntArray() {
        return new int[] { card0, card1, card2 };
    }

    /**
     * method that compares other object of its class
     * @return number that indicates both objects are equal or one is larger than the other or one is smaller than the other
     */
    @Override
    public int compareTo(Hand other) {
        int thisSum = 0;
        int otherSum = 0;
        for (int card: this.getAsIntArray()) {
            thisSum += card;
        }
        for (int card: other.getAsIntArray()) {
            otherSum += card;
        }
        if (thisSum == otherSum) {
            return 0;
        } else if (thisSum < 22 && otherSum < 22) {
            return thisSum > otherSum ? 1 : -1;
        } else if (thisSum < 22 || otherSum < 22) {
            return thisSum < 22 ? 1 : -1;
        } else {
            return 0;
        }
    }
}
