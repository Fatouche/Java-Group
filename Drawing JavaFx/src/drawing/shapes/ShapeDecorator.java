package drawing.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class ShapeDecorator extends Shape{
	
	protected String str;
	
	protected Shape shape;
	
	public ShapeDecorator(Shape s, String txt) {
		super(s.getOrigin());
		this.shape = s;
		this.str = txt;
	}

	public void paint(GraphicsContext gc){
		shape.paint(gc);
		gc.setFill(Color.BLACK);
		gc.setFont(Font.font(java.awt.Font.SERIF, 15));
		gc.fillText(str, shape.origin.getX() , shape.origin.getY());
	} 
	
	public boolean isOn(Point2D p){
		
		if (shape.isOn(p))
            return true;
		
	    return false;
	}
	
	public void setOrigin(double x, double y) {
		this.origin = new Point2D(x, y);
		shape.setOrigin(x, y);
	}
	
	public String getString() {
		return str;
	}
	
	public void setText(String text){
		this.str = new String(text);
	}
	
	public Shape getShape() {
        return shape;
    }
	
	public void translate(double x, double y) {
		this.origin = this.origin.add(x,y);
		shape.translate(x, y);
	}
	
	public void setSelected(boolean selected) {
		shape.setSelected(selected);
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public Point2D getOrigin() {
		return origin;
	}
	
	public ShapeDecorator clone() {
		return null;
	}
}
