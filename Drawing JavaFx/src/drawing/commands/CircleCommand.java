package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Circle;
import drawing.shapes.Shape;
import javafx.geometry.Point2D;

public class CircleCommand extends ShapeCommand {

    private Circle circle;

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
        circle = new Circle(center, radius);
        CommandHistory history;
        history = drawing.getCommandHistory();
        history.pushUndo(this);
        history.clearRedos();
        return circle;
    }

    @Override
    public void undo() {
        drawing.removeShape(circle);
        drawing.repaint();
    }

   
    public void redo() {
        drawing.addShape(circle);
        drawing.repaint();
    }
}
