public class PointTest {
    public static void main(String[] args) {
        Point p = new Point(1.0, 1.0);
        p.move(1.0, 0.0);
        System.out.println(p.getX()); //2.0

        p = new Point(1.0, 1.0);
        p.move(0.0, 1.0);
        System.out.println(p.getY()); //2.0

        p = new Point(1.0, 1.0);
        p.rotateAroundOrigin(90);
        System.out.println(p.getX()); //-1 (or close enough -- my code gives -0.9999999999 here...)
        System.out.println(p.getY()); //1

        Point p2 = new Point(2.0, 1.0);
        p2.rotateAroundOrigin(35);
        System.out.println(p2.getX()); // 1.0647276522269375
        System.out.println(p2.getY()); // 1.966304916991084

        Point p3 = new Point(-2.0, -1.0);
        p3.rotateAroundOrigin(0);
        System.out.println(p3.getX()); // -2.0
        System.out.println(p3.getY()); // -1.0

        Point p4 = new Point(-2.0, -1.0);
        p4.rotateAroundOrigin(-50);
        System.out.println(p4.getX()); // -2.051619662492057
        System.out.println(p4.getY()); // 0.8893012765514167

        Point p1 = new Point(1.0, 1.0);
        p2 = new Point(1.0, 0.0);
        double d1 = Point.distance(p1, p2);
        System.out.println(d1); // 1.0

        p1 = new Point(1.0, 1.0);
        p2 = new Point(1.0, 0.0);
        d1 = Point.distance(p1, p2);
        p3 = new Point(23.6, -34.5);
        double d2 = Point.distance(p1, p3);
        System.out.println(d2); //42.083369636948035

        p1 = new Point(1.0, 1.0);
        p4 = new Point(-23.6, 17.5);
        double d3 = Point.distance(p1, p4);
        System.out.println(d3); // 29.621107339193113

        p = new Point(1.0, 14.1);
        String x = p.toString();
        System.out.println("ToString: "+x); // ToString: (1.0, 14.1)

        p = new Point(-12, 15);
        x = p.toString();
        System.out.println("ToString: "+x); // ToString: (-12.0, 15.0)

    }
}
