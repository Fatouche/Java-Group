package drawing.handlers;

import drawing.Drawing;
import drawing.commands.CircleCommand;
import drawing.handlers.ShapeButtonHandler;
import drawing.shapes.Circle;
import drawing.shapes.Shape;
import javafx.geometry.Point2D;

/**
 * Created by lewandowski on 07/09/2017.
 */
public class CircleButtonHandler extends ShapeButtonHandler {

    public CircleButtonHandler(Drawing drawing) {
        super(drawing);
    }

    @Override
    protected void executeCreateShapeCommand() {
        CircleCommand circleCommand = new CircleCommand(drawing, origin, destination);
        circleCommand.execute();
    }

}
