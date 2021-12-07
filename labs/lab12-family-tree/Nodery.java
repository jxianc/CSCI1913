//  NODERY. Driver class, for testing. 2 points total.

public class Nodery {

//  MAIN. For testing.

    public static void main(String[] args) {
        Node n = new Node("Harry");
        n.setFather(new Node("James"));
        n.setMother(new Node("Lily"));
        String s = n.getFather().getName();
        System.out.println(s);                           // James
        s = n.getMother().getName();
        System.out.println(s);                           // Lily
    }
}
/*

James
Lily

 */