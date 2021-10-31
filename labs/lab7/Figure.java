public class Figure {
    public static void main(String[] args) {
        ShapeDrawer drawer = new ShapeDrawer(600, 600);
        Point[] octagon = new Point[8];
        octagon[0] = new Point(200, 100);
        octagon[1] = new Point(400, 100);
        octagon[2] = new Point(500, 200);
        octagon[3] = new Point(500, 400);
        octagon[4] = new Point(400, 500);
        octagon[5] = new Point(200, 500);
        octagon[6] = new Point(100, 400);
        octagon[7] = new Point(100, 200);
        Polygon poly = new Polygon(octagon);
        drawer.draw(poly);
        drawer.writeToFile("image.png");
    }
}
