package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Rectangle;
import drawing.shapes.Shape;
import javafx.geometry.Point2D;

public class RectangleCommand extends ShapeCommand {


    public RectangleCommand(Drawing drawing, Point2D origin, Point2D destination) {
        super(drawing, origin, destination);
    }

    @Override
    protected Shape createShape() {
        double x = Math.min(origin.getX(),destination.getX());
        double y = Math.min(origin.getY(),destination.getY());
        double width = Math.abs(destination.getX()-origin.getX());
        double height = Math.abs(destination.getY()-origin.getY());
        return new Rectangle(new Point2D(x, y), width, height);
    }

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
