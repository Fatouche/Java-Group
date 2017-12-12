package drawing.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public abstract class ShapeDecorator {
	protected Point2D origin;
	protected boolean selected = false;
	protected String s;

	public ShapeDecorator(Point2D origin, String str) {
		this.origin = new Point2D(origin.getX(), origin.getY());
		this.s = str;
	}

	public Point2D getOrigin() {
		return origin;
	}

	public void setText(String text)
	{
		this.s = new String(text);
	}
	
	public String getString() {
		return s;
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

	public abstract ShapeDecorator clone() ;
}
