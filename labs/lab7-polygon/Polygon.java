public class Polygon {
    public Point[] points;

    /**
     * constructor for Polygon
     * @param points an array of Point object
     */
    public Polygon(Point[] points) {
        this.points = points;
    }

    /**
     * method that gets the number of points in the polygon
     * @return number of points in the polygon
     */
    public int getNumPoints() {
        return points.length;
    }

    /**
     * method that gets the specific point of the polygon based on the given index
     * @param index index of point in the polygon
     * @return  specific point of the polygon
     */
    public Point getPoint(int index) {
        if (0 <= index && index < points.length) {
            return points[index];
        } else {
            // given index is invalid
            return null;
        }
    }

    /**
     * method that gets center point of the polygon by returning average x and y value
     * @return center point 
     */
    public Point getCenter() {
        double totalX = 0;
        double totalY = 0;
        for (int i=0; i<points.length; i++) {
            totalX += points[i].x;
            totalY += points[i].y;
        }
        Point centerPoint = new Point(totalX / points.length, totalY / points.length);
        return centerPoint;
    }

    /**
     * method that calculate the perimeter of polygon
     * @return perimeter of polygon
     */
    public double getPerimeter() {
        double perimeter = 0;
        int i;
        for (i=0; i<points.length-1; i++) {
            Point p1 = points[i];
            Point p2 = points[i+1];
            perimeter += Point.distance(p1, p2);
        }
        Point lastPoint = points[i];
        Point firstPoint = points[0];
        perimeter += Point.distance(firstPoint, lastPoint);
        return perimeter;
    }

    /**
     * method that return a string representation of the polygon
     * @return a string that represents the polygon
     */
    public String toString() {
        String returnString = "";
        for (int i=0; i<points.length; i++) {
            if ((i+1) != points.length) {
                returnString += (points[i].toString() + " -- ");
            } else {
                returnString += points[i].toString();
            }
        }
        return returnString;
    }

    /**
     * method that move current polygon by changing the value of x and y of each point
     * @param dx change of x in x-axis
     * @param dy change of y in y-axis
     */
    public void move(double dx, double dy) {
        for (int i=0; i<points.length; i++) {
            points[i].x += dx;
            points[i].y += dy;
        }
    }

    /**
     * method that get the left-most (minimum x) point and top-most (minimum y) point
     * @return top left point
     */
    public Point getTopLeft() {
        double minX = points[0].x;
        double minY = points[0].y;
        for (int i=1; i<points.length; i++) {
            minX = Math.min(minX, points[i].x);
            minY = Math.min(minY, points[i].y);
        }
        Point topLeftPoint = new Point(minX, minY);
        return topLeftPoint;
    }

    /**
     * method that get the right-most (maximum x) point and bottom-most (maximum y) point
     * @return bottom right point
     */
    public Point getBottomRight() {
        double maxX = points[0].x;
        double maxY = points[0].y;
        for (int i=1; i<points.length; i++) {
            maxX = Math.max(maxX, points[i].x);
            maxY = Math.max(maxY, points[i].y);
        }
        Point bottomRightPoint = new Point(maxX, maxY);
        return bottomRightPoint;
    }

    /**
     * method that rotates the polygon around its center point
     * @param theta angle in degree
     */
    public void rotateAroundCenter(double theta) {
        Point centerPoint = getCenter();
        Point origin = new Point(0, 0);
        // calculate the distance between center point and origin
        double xDiff = origin.x - centerPoint.x;
        double yDiff = origin.y - centerPoint.y;
        // move polygon to origin
        move(xDiff, yDiff);
        // rotate polygon around origin
        for (int i=0; i<points.length; i++) {
            points[i].rotateAroundOrigin(theta);
        }
        // move back to polygon center
        move(-1 * xDiff, -1 * yDiff);
    }
}