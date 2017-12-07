package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Shape;
import javafx.geometry.Point2D;

public abstract class ShapeCommand implements Command {

    protected Drawing drawing;
    protected Point2D origin;
    protected Point2D destination;

    public ShapeCommand(Drawing drawing, Point2D origin, Point2D destination) {
        this.drawing = drawing;
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void execute() {
        drawing.addShape(createShape());
    }

    protected abstract Shape createShape();
}
