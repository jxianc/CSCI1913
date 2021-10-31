public class Point {
    public double x;
    public double y;

    /**
     * constructor for Point
     * @param x x
     * @param y y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * method that gets the current x value
     * @return value of current x
     */
    public double getX() {
        return x;
    }

    /**
     * method that gets the current y value
     * @return value of current y
     */
    public double getY() {
        return y;
    }

    /**
     * method that moves current point by changing the value of current x and y
     * @param dx change of x in x-axis
     * @param dy change of y in y-axis
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * method that rotates current point around the origin
     * @param theta angle in degree
     */
    public void rotateAroundOrigin(double theta) {
        // convert degree to radian
        theta = Math.toRadians(theta);
        // set x and y to temporary variables
        double tempX = x;
        double tempY = y;
        x = (tempX * Math.cos(theta)) - (tempY * Math.sin(theta));
        y = (tempY * Math.cos(theta)) + (tempX * Math.sin(theta));
    }

    /**
     * method that return a string representation of current point
     * @return a string that represents the current point
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * method that calculate the distance between two points
     * @param p1 first point
     * @param p2 second point
     * @return distance between two points
     */
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }
}
