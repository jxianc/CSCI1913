public class LinkedCounterTester {
    // helpful method to print a counter so we can test 
    // various properties repeatedly.    
    public static <T> void printCounter(LinkedCounter<T> counter) {
        int size = counter.getSize();
        int sum = counter.getSum();
        String s = counter.toString();
        boolean empty = counter.isEmpty();
        System.out.println(size+" "+sum+" "+empty);
        System.out.println("toString:"+s);
    }
    
    public static void main(String[] args) {
        LinkedCounter<String> words = new LinkedCounter<>();
        printCounter(words);                               // 0 0 true
                                                           // toString:
        System.out.println(words.getCount("eggplant"));    // 0
        System.out.println(words.getCount("sparrow"));     // 0
        System.out.println(words.countUp("eggplant"));     // 1
        printCounter(words);                               // 1 1 false
                                                           // toString:eggplant:1
        System.out.println(words.getCount("eggplant"));    // 1
        System.out.println(words.getCount("sparrow"));     // 0
        System.out.println(words.countUp("eggplant"));     // 2
        System.out.println(words.countUp("eggplant"));     // 3
        System.out.println(words.countUp("eggplant"));     // 4
        printCounter(words);                               // 1 4 false
                                                           // toString:eggplant:4
        System.out.println(words.getCount("eggplant"));    // 4
        System.out.println(words.getCount("sparrow"));     // 0
        System.out.println(words.countDown("eggplant"));   // 3
        System.out.println(words.countDown("eggplant"));   // 2
        System.out.println(words.countDown("sparrow"));    // 0
        printCounter(words);                               // 1 2 false
                                                           // toString:eggplant:2
        System.out.println(words.getCount("eggplant"));    // 2
        System.out.println(words.getCount("sparrow"));     // 0

        System.out.println(words.countDown("eggplant"));   // 1
        System.out.println(words.countDown("eggplant"));   // 0
        System.out.println(words.countDown("eggplant"));   // 0
        printCounter(words);                               // 0 0 true
                                                           // toString:
        System.out.println(words.getCount("eggplant"));    // 0
        System.out.println(words.getCount("sparrow"));     // 0

        LinkedCounter<Boolean> boo = new LinkedCounter<>();
        printCounter(words);                               // 0 0 true
                                                           // toString:
        boo.countUp(true);
        boo.countUp(false);
        boo.countUp(true);
        boo.countUp(null);
        boo.countUp(true);
        boo.countUp(false);
        printCounter(boo);                                 // 3 6 false
                                                           // toString:null:1 -> false:2 -> true:3
        int i;
        i = boo.getCount(null);                            // 1
        System.out.println(i);
        i = boo.getCount(false);                           // 2
        System.out.println(i);
        i = boo.getCount(true);                            // 3
        System.out.println(i);
        
        boo.countDown(true);
        boo.countDown(false);
        boo.countDown(false);
        printCounter(boo);                                 // 2 3 false
                                                           // toString:null:1 -> true:2
        i = boo.getCount(null);                            // 1
        System.out.println(i);
        i = boo.getCount(false);                           // 0
        System.out.println(i);
        i = boo.getCount(true);                            // 2
        System.out.println(i);
        
        boo.countDown(true);
        boo.countDown(true);
        boo.countDown(true);
        printCounter(boo);                                 // 1 1 false
                                                           // toString:null:1
        i = boo.getCount(null);                            // 1
        System.out.println(i);
        i = boo.getCount(false);                           // 0
        System.out.println(i);
        i = boo.getCount(true);                            // 0
        System.out.println(i);
        
        boo.countUp(true);
        printCounter(boo);                                 // 2 2 false
                                                           // toString:true:1 -> null:1
        i = boo.getCount(null);                            // 1
        System.out.println(i);
        i = boo.getCount(true);                            // 1
        System.out.println(i);
        
        boo.countDown(true);
        printCounter(boo);                                 // 1 1 false
                                                           // toString:null:1
        i = boo.getCount(null);                            // 1
        System.out.println(i);
        i = boo.getCount(true);                            // 0
        System.out.println(i);
        
        boo.countDown(null);
        printCounter(boo);                                 // 0 0 true
                                                           // toString:
        i = boo.getCount(null);                            // 0
        System.out.println(i);
    }
}
/*

0 0 true
toString:
0
0
1
1 1 false
toString:eggplant:1
1
0
2
3
4
1 4 false
toString:eggplant:4
4
0
3
2
0
1 2 false
toString:eggplant:2
2
0
1
0
0
0 0 true
toString:
0
0
0 0 true
toString:
3 6 false
toString:null:1 -> false:2 -> true:3
1
2
3
2 3 false
toString:null:1 -> true:2
1
0
2
1 1 false
toString:null:1
1
0
0
2 2 false
toString:true:1 -> null:1
1
1
1 1 false
toString:null:1
1
0
0 0 true
toString:
0
 */