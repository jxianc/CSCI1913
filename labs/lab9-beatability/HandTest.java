public class HandTest {
    // Tests: all results should be true
    public static void main(String[] args) {
        // Tie condition 1: thisSum == oSum
        Hand h1 = new Hand(1, 2, 3);
        Hand h2 = new Hand(1, 2, 3);
        System.out.println(h1.compareTo(h2) == 0); // true

        // Tie condition 2: thisSum > 21 and oSum > 21
        h1 = new Hand(11, 10, 3);
        h2 = new Hand(1, 12, 13);
        System.out.println(h1.compareTo(h2) == 0); // true

        // Win condition 1: thisSum is less than or equal to 21 and thisSum > oSum
        h1 = new Hand(11, 8, 2);
        h2 = new Hand(1, 2, 3);
        System.out.println(h1.compareTo(h2) > 0); // true
        h1 = new Hand(11, 3, 2);
        h2 = new Hand(1, 2, 3);
        System.out.println(h1.compareTo(h2) > 0); // true

        // Win condition 2: thisSum is less than or equal to 21 and oSum is greater than 21
        h1 = new Hand(11, 3, 2);
        h2 = new Hand(11, 12, 3);
        System.out.println(h1.compareTo(h2) > 0); // true
        h1 = new Hand(11, 3, 7);
        h2 = new Hand(11, 12, 3);
        System.out.println(h1.compareTo(h2) > 0); // true

        // Lose condition 1: thisSum is greater than 21 and oSum is less than or equal to 21
        h1 = new Hand(11, 13, 7);
        h2 = new Hand(11, 2, 3);
        System.out.println(h1.compareTo(h2) < 0); // true
        h1 = new Hand(11, 13, 7);
        h2 = new Hand(11, 7, 3);
        System.out.println(h1.compareTo(h2) < 0); // true

        // Lose condition 2: thisSum < oSum and oSum is less than or equal to 21
        h1 = new Hand(11, 3, 1);
        h2 = new Hand(11, 2, 3);
        System.out.println(h1.compareTo(h2) < 0); // true
        h1 = new Hand(11, 3, 1);
        h2 = new Hand(11, 7, 3);
        System.out.println(h1.compareTo(h2) < 0); // true
    }
}
