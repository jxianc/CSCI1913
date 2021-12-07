//  POTTERY. Driver class, for testing. Each comment shows what should be printed and is worth 2 points.

public class Pottery {

//  MAIN. For testing. Each comment shows what is expected, and each print is worth 2 points.

    public static void main(String[] args) {
        FamilyTree family = new FamilyTree("Al");

        family.addParents("Al", "Harry", "Ginny");
        family.addParents("Harry", "James", "Lily");
        family.addParents("Ginny", "Arthur", "Molly");
        // Note -- Joanne isn't in the tree so this shouldn't actually change anything.
        family.addParents("Joanne", "Peter", "Anne");
        // Running to this point without error is worth                  2 points.

        System.out.println(family.isDescendant("Joanne", "Joanne"));  // false

        System.out.println(family.isDescendant("Al", "Al"));          // true
        System.out.println(family.isDescendant("Al", "Harry"));       // true
        System.out.println(family.isDescendant("Al", "Ginny"));       // true
        System.out.println(family.isDescendant("Al", "James"));       // true
        System.out.println(family.isDescendant("Al", "Lily"));        // true
        System.out.println(family.isDescendant("Al", "Arthur"));      // true
        System.out.println(family.isDescendant("Al", "Molly"));       // true
        System.out.println(family.isDescendant("Al", "Joanne"));      // false

        System.out.println(family.isDescendant("Harry", "Harry"));    // true
        System.out.println(family.isDescendant("Harry", "Al"));       // false
        System.out.println(family.isDescendant("Harry", "James"));    // true
        System.out.println(family.isDescendant("Harry", "Lily"));     // true
        System.out.println(family.isDescendant("Harry", "Ginny"));    // false
        System.out.println(family.isDescendant("Harry", "Arthur"));   // false
        System.out.println(family.isDescendant("Harry", "Molly"));    // false
        System.out.println(family.isDescendant("Harry", "Joanne"));   // false

        System.out.println(family.isDescendant("Ginny", "Arthur"));   // true
        System.out.println(family.isDescendant("Arthur", "Ginny"));   // false

        System.out.println(family.getMotherByName("Harry"));          // Lily
        System.out.println(family.getMotherByName("James"));          // null

        System.out.println(family.getFatherByName("Ginny"));          // Arthur
        System.out.println(family.getFatherByName("Molly"));          // null
    }
}
