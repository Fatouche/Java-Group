package drawing.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by lewandowski on 07/09/2017.
 */
public abstract class Shape{
    protected Point2D origin;
    protected boolean selected = false;

    public Shape(Point2D origin) {
        this.origin = new Point2D(origin.getX(), origin.getY());
    }

    public Point2D getOrigin() {
        return origin;
    }

    public abstract void paint(GraphicsContext gc) ;

    public abstract boolean isOn(Point2D p);

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setOrigin(double x, double y) {
        this.origin = new Point2D(x, y);
    }

    public void translate(double x, double y) {
        this.origin = this.origin.add(x,y);
    }

    public abstract Shape clone() ;

        
}
