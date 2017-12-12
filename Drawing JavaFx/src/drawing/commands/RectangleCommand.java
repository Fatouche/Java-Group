package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Rectangle;
import drawing.shapes.Shape;
import javafx.geometry.Point2D;

public class RectangleCommand extends ShapeCommand {

    private Rectangle rectangle;

    public RectangleCommand(Drawing drawing, Point2D origin, Point2D destination) {
        super(drawing, origin, destination);
    }

    @Override
    protected Shape createShape() {
        double x = Math.min(origin.getX(),destination.getX());
        double y = Math.min(origin.getY(),destination.getY());
        double width = Math.abs(destination.getX()-origin.getX());
        double height = Math.abs(destination.getY()-origin.getY());
        rectangle = new Rectangle(new Point2D(x, y), width, height);
        CommandHistory history;
        history = drawing.getCommandHistory();
        history.pushUndo(this);
        history.clearRedos();
        return rectangle;
    }

    @Override
    public void undo() {
        drawing.removeShape(rectangle);
        drawing.repaint();
    }

    @Override
    public void redo() {
        drawing.addShape(rectangle);
        drawing.repaint();
    }
}
