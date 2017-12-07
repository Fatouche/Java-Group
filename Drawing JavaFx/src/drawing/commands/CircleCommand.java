package drawing.commands;



import drawing.Drawing;
import drawing.shapes.Circle;
import drawing.shapes.Shape;
import javafx.geometry.Point2D;

public class CircleCommand extends ShapeCommand {

	

    public CircleCommand(Drawing drawing, Point2D origin, Point2D destination) {
        super(drawing, origin, destination);
    }

    @Override
    protected Shape createShape() {
        double width = Math.abs(destination.getX()-origin.getX());
        double height = Math.abs(destination.getY()-origin.getY());
        double radius = Math.max(width, height)/2;
        double centerX = (destination.getX()+origin.getX())/2;
        double centerY = (destination.getY()+origin.getY())/2;
        Point2D center = new Point2D((int)centerX, (int)centerY);
        return new Circle(center, radius);
    }

	@Override
	public void undo() {
		
	}
}
