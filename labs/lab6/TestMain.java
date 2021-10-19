public class TestMain {

    public static void main(String[] args) {
        // TEST NEXT #1
        RNGUtilities.seed(10);
        for (int i = 0; i < 10; i++) {
            System.out.print(RNGUtilities.next());
            System.out.print(", ");
        }
        System.out.println();
        //750, 56250, 24382, 59151, 45346, 58563, 1246, 27913, 61828, 49510,

        // TEST NEXT #2 -- test 2
        // do it again, (this makes sure we're using that seed appropriately!)
        RNGUtilities.seed(10);
        for (int i = 0; i < 10; i++) {
            System.out.print(RNGUtilities.next());
            System.out.print(", ");
        }
        System.out.println();
        // 750, 56250, 24382, 59151, 45346, 58563, 1246, 27913, 61828, 49510,

        // TEST NEXT #2 -- test 2
        RNGUtilities.seed(33);
        for (int i = 0; i < 10; i++) {
            System.out.print(RNGUtilities.next());
            System.out.print(", ");
        }
        System.out.println();
        // 2475, 54551, 28031, 5141, 57890, 16308, 43434, 46237, 59851, 32309,

        // TEST NEXT INT #1
        RNGUtilities.seed(2013);
        for (int i = 0; i < 20; i++) {
            System.out.print(RNGUtilities.nextInt(0, 5));
            System.out.print(", ");
        }
        System.out.println();
        // 1, 1, 4, 3, 4, 3, 4, 1, 1, 4, 0, 3, 0, 4, 3, 1, 1, 0, 0, 3,

        // TEST NEXT INT #2
        RNGUtilities.seed(423);
        for (int i = 0; i < 10; i++) {
            System.out.print(RNGUtilities.nextInt(5, 15));
            System.out.print(", ");
        }
        System.out.println();
        // 10, 8, 6, 10, 10, 5, 6, 10, 9, 11,

        // TEST SEQUENCE #1
        int[] seq = RNGUtilities.sequenceArray(5);
        System.out.println(seq.length);
        // 5
        for (int i = 0; i < 5; i++) {
            System.out.print(seq[i]);
            System.out.print(", ");
        }
        System.out.println();
        // 0, 1, 2, 3, 4,

        // TEST SEQUENCE #2
        seq = RNGUtilities.sequenceArray(15);
        System.out.println(seq.length);
        // 15
        for (int i = 0; i < 15; i++) {
            System.out.print(seq[i]);
            System.out.print(", ");
        }
        System.out.println();
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,

        // TEST RANDOM ARRAY #1
        RNGUtilities.seed(134);
        seq = RNGUtilities.randomArray(13, 3, 13);
        System.out.println(seq.length);
        // 13
        for (int i = 0; i < 13; i++) {
            System.out.print(seq[i]);
            System.out.print(", ");
        }
        System.out.println();
        // 3, 6, 9, 12, 9, 8, 12, 10, 12, 7, 10, 9, 10,

        // TEST RANDOM ARRAY #2
        RNGUtilities.seed(134);
        seq = RNGUtilities.randomArray(4, 2, 4);
        System.out.println(seq.length);
        // 4
        for (int i = 0; i < 4; i++) {
            System.out.print(seq[i]);
            System.out.print(", ");
        }
        System.out.println();
        //2, 3, 2, 3,

        // TEST RANDOM ARRAY #3
        RNGUtilities.seed(12314);
        seq = RNGUtilities.randomArray(5, -10, -5);
        System.out.println(seq.length);
        // 5
        for (int i = 0; i < 5; i++) {
            System.out.print(seq[i]);
            System.out.print(", ");
        }
        System.out.println();
        //-8, -7, -9, -8, -10,

        // Test Shuffle 1
        seq = RNGUtilities.sequenceArray(15);
        System.out.println(seq.length);
        // 15
        RNGUtilities.seed(31);
        RNGUtilities.shuffle(seq);

        for (int i = 0; i < 15; i++) {
            System.out.print(seq[i]);
            System.out.print(", ");
        }
        System.out.println();
        // 2, 8, 6, 4, 14, 7, 10, 3, 9, 11, 1, 12, 5, 13, 0,

        // Test Shuffle 2
        RNGUtilities.seed(31);
        RNGUtilities.shuffle(seq);
        for (int i = 0; i < 15; i++) {
            System.out.print(seq[i]);
            System.out.print(", ");
        }
        System.out.println();
        // note -- this won't be the same, it will be the same numbers, but
        // it will be the same **reordering**
        // 6, 9, 10, 14, 0, 3, 1, 4, 11, 12, 8, 5, 7, 13, 2,

        // Test Sort 1
        RNGUtilities.sort(seq);
        for (int i = 0; i < 15; i++) {
            System.out.print(seq[i]);
            System.out.print(", ");
        }
        System.out.println();
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,

        // Test Sort 2
        RNGUtilities.seed(8);
        seq = RNGUtilities.randomArray(10, 10, 20);
        RNGUtilities.sort(seq);
        for (int i = 0; i < 10; i++) {
            System.out.print(seq[i]);
            System.out.print(", ");
        }
        System.out.println();
        // 10, 10, 12, 13, 13, 13, 15, 16, 18, 19,
    }
}
