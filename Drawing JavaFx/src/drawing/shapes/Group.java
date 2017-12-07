package drawing.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lewandowski on 12/09/2017.
 */
public class Group extends Shape {

    private ArrayList<Shape> shapes = new ArrayList<>();

    public Group(Collection<Shape> list) {
        super(new Point2D(0,0));
        shapes.addAll(list);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void paint(GraphicsContext gc) {
        for (Shape s: shapes)
            s.paint(gc);
    }

    @Override
    public boolean isOn(Point2D p) {
        for (Shape s: shapes) {
            if (s.isOn(p))
                return true;
        }
        return false;
    }

    @Override
    public void setOrigin(double x, double y) {
        super.setOrigin(x, y);
        for (Shape s: shapes)
            s.setOrigin(x, y);
    }

    @Override
    public void translate(double x, double y) {
        super.translate(x, y);
        for (Shape s: shapes)
            s.translate(x, y);
    }

    public Collection<Shape> getShapes() {
        return  shapes;
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        for (Shape s: shapes)
            s.setSelected(selected);
    }

    @Override
    public Shape clone() {
        ArrayList<Shape> liste = new ArrayList<>();
        for (Shape s: shapes)
            liste.add(s.clone());
        return new Group(liste);
    }
}
