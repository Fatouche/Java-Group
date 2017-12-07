package drawing.handlers;

import drawing.Drawing;
import drawing.commands.RectangleCommand;
import drawing.handlers.ShapeButtonHandler;
import drawing.shapes.Rectangle;
import drawing.shapes.Shape;
import javafx.geometry.Point2D;

/**
 * Created by lewandowski on 07/09/2017.
 */
public class RectangleButtonHandler extends ShapeButtonHandler {

    public RectangleButtonHandler(Drawing drawing) {
        super(drawing);
    }

    @Override
    protected void executeCreateShapeCommand() {
        RectangleCommand rectCommand = new RectangleCommand(drawing, origin, destination);
        rectCommand.execute();
    }

}
