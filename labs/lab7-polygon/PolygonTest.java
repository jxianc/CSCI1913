public class PolygonTest {
    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(0.0, 0.0);
        points[1] = new Point(1.0, 0.0);
        points[2] = new Point(2.0, 3.0);
        Polygon polygon1 = new Polygon(points);
        System.out.println(polygon1.getNumPoints()); // 3
        System.out.println(polygon1.getPoint(-1)); // null
        System.out.println(polygon1.getPoint(3)); // null

        Point p0 = polygon1.getPoint(0);
        System.out.println(p0); // (0.0, 0.0)

        Point p1 = polygon1.getPoint(2);
        System.out.println(p1); // (2.0, 3.0)

        p0 = polygon1.getCenter();
        System.out.println(p0); // (1.0, 1.0)

        Point[] points2 = new Point[4];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        points2[3] = new Point(-16.0, -28.0);
        Polygon polygon2 = new Polygon(points2);
        p1 = polygon2.getCenter();
        System.out.println(p1); // (-2.75, -2.25)

        points2 = new Point[5];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        points2[3] = new Point(-10.0, 17.0);
        points2[4] = new Point(-16.0, -28.0);
        polygon2 = new Polygon(points2);
        p1 = polygon2.getCenter();
        System.out.println(p1); // (-4.2, 1.6)


        points2 = new Point[3];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        polygon2 = new Polygon(points2);
        double c1 = polygon2.getPerimeter();
        System.out.println(c1); // 107.12493335531502


        points2 = new Point[4];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        points2[3] = new Point(-16.0, -28.0);
        polygon2 = new Polygon(points2);
        c1 = polygon2.getPerimeter();
        System.out.println(c1); // 172.4709679604694


        points2 = new Point[5];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        points2[3] = new Point(-10.0, 17.0);
        points2[4] = new Point(-16.0, -28.0);
        polygon2 = new Polygon(points2);
        c1 = polygon2.getPerimeter();
        System.out.println(c1); // 181.74549591039417


        points2 = new Point[5];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        points2[3] = new Point(-10.0, 17.0);
        points2[4] = new Point(-16.0, -28.0);

        polygon2 = new Polygon(points2);
        polygon2.move(1.2, -3.4);
        for (int i = 0; i < points2.length; ++i) {
            System.out.println(polygon2.getPoint(i));
        }

        // (13.2, 11.6)
        // (14.2, -17.4)
        // (-18.8, 14.6)
        // (-8.8, 13.6)
        // (-14.8, -31.4)

        points2 = new Point[4];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        points2[3] = new Point(-16.0, -28.0);

        polygon2 = new Polygon(points2);
        System.out.println(polygon2.getTopLeft()); // (-20.0, -28.0)
        System.out.println(polygon2.getTopLeft()); // (-20.0, -28.0)


        points2 = new Point[5];
        points2[0] = new Point(2.0, 5.0);
        points2[1] = new Point(1.3, -5.3);
        points2[2] = new Point(-6.3, 8.2);
        points2[3] = new Point(-4.2, -8.9);
        points2[4] = new Point(4.5, -14.4);

        polygon2 = new Polygon(points2);
        System.out.println(polygon2.getTopLeft()); // (-6.3, -14.4)
        System.out.println(polygon2.getTopLeft()); // (-6.3, -14.4)


        points2 = new Point[4];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        points2[3] = new Point(-16.0, -28.0);
        points2[1] = new Point(14.0, -14.0);

        polygon2 = new Polygon(points2);
        System.out.println(polygon2.getBottomRight()); // (14.0, 18.0)
        System.out.println(polygon2.getBottomRight()); // (14.0, 18.0)


        points2 = new Point[5];
        points2[0] = new Point(2.0, 5.0);
        points2[1] = new Point(1.3, -5.3);
        points2[2] = new Point(-6.3, 8.2);
        points2[3] = new Point(-4.2, -8.9);
        points2[4] = new Point(4.5, -14.4);

        polygon2 = new Polygon(points2);
        System.out.println(polygon2.getBottomRight()); // (4.5, 8.2)
        System.out.println(polygon2.getBottomRight()); // (4.5, 8.2)


        points2 = new Point[4];
        points2[0] = new Point(1.0, 1.0);
        points2[1] = new Point(2.0, 1.0);
        points2[2] = new Point(2.0, 2.0);
        points2[3] = new Point(1.0, 2.0);

        polygon2 = new Polygon(points2);
        polygon2.rotateAroundCenter(90);
        for (int i = 0; i < points2.length; ++i) {
            System.out.println(polygon2.getPoint(i));
        }

        points2 = new Point[5];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        points2[3] = new Point(-10.0, 17.0);
        points2[4] = new Point(-16.0, -28.0);

        polygon2 = new Polygon(points2);
        polygon2.rotateAroundCenter(100);
        for (int i = 0; i < points2.length; ++i) {
            System.out.println(polygon2.getPoint(i));
        }
        //(-20.20952436856786, 15.227000018060902)
        //(8.176252291119244, 21.24760492341409)
        //(-17.607205942262713, -16.807792611330544)
        //(-18.358879965919808, -6.786066903541533)
        //(26.999357985631136, -4.880745426602919)


        points2 = new Point[5];
        points2[0] = new Point(12.0, 15.0);
        points2[1] = new Point(13.0, -14.0);
        points2[2] = new Point(-20.0, 18.0);
        points2[3] = new Point(-10.0, 17.0);
        points2[4] = new Point(-16.0, -28.0);
        polygon2 = new Polygon(points2);
        String x = polygon2.toString();
        System.out.println("ToString: "+x);
        //ToString: (12.0, 15.0) -- (13.0, -14.0) -- (-20.0, 18.0) -- (-10.0, 17.0) -- (-16.0, -28.0)
    }
}