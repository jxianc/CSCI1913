public class CountNodeTester {
    public static void main(String[] args) {
        CountNode<String> node1 = new CountNode<>("apple", null);
        CountNode<String> node2 = new CountNode<>("eggplant", node1);

        // used to check return types.
        String s;
        CountNode<String> cns;
        int i;

        System.out.println("node 1");                      // node 1
        s = node1.getData();
        System.out.println(s);                             // apple
        cns = node1.getNext();
        System.out.println(cns == null);                   // true
        i = node1.getCount();
        System.out.println(i);                             // 1

        System.out.println("node 2");                      // node 2
        s = node2.getData();
        System.out.println(s);                             // eggplant
        cns = node2.getNext();
        System.out.println(cns == node1);                  // true
        i = node2.getCount();
        System.out.println(i);                             // 1

        node1.countUp();
        node2.countUp();
        node2.countUp();
        i = node1.getCount();
        System.out.println(i);                             // 2
        i = node2.getCount();
        System.out.println(i);                             // 3

        node1.countDown();
        node1.countDown();
        node2.countDown();
        i = node1.getCount();
        System.out.println(i);                             // 0
        i = node2.getCount();
        System.out.println(i);                             // 2

        node1.countDown();
        // should stay at 0.
        i = node1.getCount();
        System.out.println(i);                             // 0

        node1.setNext(node2);

        cns = node1.getNext();
        System.out.println(cns == null);                   // false
        System.out.println(cns == node2);                  // true
        cns = node1.getNext().getNext();
        System.out.println(cns == node1);                  // true

        s = node1.toString();
        System.out.println(s);                             // apple:0
        s = node2.toString();
        System.out.println(s);                             // eggplant:2

        CountNode<Double> node3 = new CountNode<>(32.1, null);
        System.out.println("node 3");                      // node 3
        double d = node3.getData();
        System.out.println(d);                             // 32.1
        CountNode<Double> cnd = node3.getNext();
        System.out.println(cnd == null);                   // true
        i = node3.getCount();
        System.out.println(i);                             // 1
        s = node3.toString();
        System.out.println(s);                             // 32.1:1
    }
}
/*

node 1
apple
true
1
node 2
eggplant
true
1
2
3
0
2
0
false
true
true
apple:0
eggplant:2
node 3
32.1
true
1
32.1:1

 */