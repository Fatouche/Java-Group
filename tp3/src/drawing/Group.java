package drawing;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;

public class Group extends Shape implements Iterable<Shape> {

    private ArrayList<Shape> shapes;
    
    public Group() {
        super(new Point2D(0, 0));
        shapes = new ArrayList<>();
    }
    
    public Group(Group clo) {	
        super(clo.origin);
        shapes = new ArrayList<>();
        for(Shape maVal : clo.shapes){
        	shapes.add(maVal.clone());
        }
    }

    @Override
    public void paint(GraphicsContext gc) {
        for (Shape shape : shapes) {
            shape.paint(gc);
        }
    }

    @Override
    public boolean isOn(Point2D p) {
        for (Shape shape : shapes)
            if (shape.isOn(p))
                return true;
        return false;
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void setOrigin(double x, double y) {
        if (origin == null) {
            super.setOrigin(x, y);
            return;
        }
        double tX = x - origin.getX();
        double tY = y - origin.getY();
        origin = new Point2D(x, y);
        for (Shape shape : shapes)
            shape.setOrigin(shape.getOrigin().getX() + tX, shape.getOrigin().getY() + tY);

    }

	@Override
	public Shape clone() {
		return new Group(this);
	}
}
