import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class ShapeDrawer {
    private final BufferedImage image;
    private final double maxX;
    private final double maxY;
    private final Graphics2D graphics;
    private Color stroke;
    private Color fill;

    public ShapeDrawer(double maxX, double maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.image = new BufferedImage((int)Math.ceil(maxX), (int)Math.ceil(maxY), TYPE_INT_RGB);
        this.graphics = image.createGraphics();

        // turn on anti-aliasing and set other "hints" to "favor quality over speed"
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHints(rh);
        rh = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHints(rh);
        rh = new RenderingHints(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHints(rh);
        stroke = Color.green;
        fill = Color.gray;
        reset();
    }

    /**
     * Change the color used when drawing the outline of a shape
     * @param stroke the new color. The type is java.awt.color.
     * For more information see: https://docs.oracle.com/javase/10/docs/api/java/awt/Color.html
     */
    public void setStroke(Color stroke) {
        this.stroke = stroke;
    }

    /**
     * Change the color used when drawing the inside of a shape
     * @param fill the new color. The type is java.awt.color.
     * For more information see: https://docs.oracle.com/javase/10/docs/api/java/awt/Color.html
     */
    public void setFill(Color fill) {
        this.fill = fill;
    }

    /**
     * Draw a polygon onto the shapeDrawer.
     * If other shapes have already been drawn, draw on top of those shapes.
     */
    public void draw(Polygon poly) {
        // create a java.awt.polygon representation of the same data
        java.awt.Polygon awtPoly = new java.awt.Polygon();
        for(int i = 0; i < poly.getNumPoints(); i++) {
            Point p = poly.getPoint(i);
            awtPoly.addPoint((int)Math.round(p.getX()), (int)Math.round(p.getY()));
        }

        graphics.setColor(fill);
        graphics.fillPolygon(awtPoly);
        graphics.setColor(stroke);
        graphics.drawPolygon(awtPoly);
    }

    /**
     * Reset the drawing. (so set it back to a black rectangle)
     * This does not reset the stroke and fill colors.
     */
    public void reset() {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,(int)Math.ceil(maxX), (int)Math.ceil(maxY));
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    /**
     * Save to a file.
     * @param fileName the name, or file path and name, of the file you want to make. This should end in ".png" since
     *                 This code asks Java to encode the image in png format.
     * @return The return value is a boolean. True indicates the image was written successfully. False indicates Failure.
     * If the image writing fails, often, but not always, there will be an error message printed as well.
     */
    public boolean writeToFile(String fileName) {
        try {
            return ImageIO.write(image, "png", new File(fileName));
        } catch (IOException e) {
            System.out.println("Saving to file failed.");
            e.printStackTrace();
            return false;
        }
    }
}
