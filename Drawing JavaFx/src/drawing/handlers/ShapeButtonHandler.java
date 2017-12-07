package drawing.handlers;

import drawing.Drawing;
import drawing.shapes.Shape;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 07/09/2017.
 */
public abstract class ShapeButtonHandler implements EventHandler<Event> {

    protected Drawing drawing;
    protected Point2D origin;
    protected Point2D destination;

    public ShapeButtonHandler(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void handle(Event event) {

        if (event instanceof ActionEvent) {
            drawing.addEventFilter(MouseEvent.ANY, this);
        }

        if (event instanceof MouseEvent) {
            event.consume();

            if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                origin = new Point2D( ((MouseEvent)event).getX(), ((MouseEvent)event).getY());
            }

            if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
                destination = new Point2D( ((MouseEvent)event).getX(), ((MouseEvent)event).getY());

                executeCreateShapeCommand();

                drawing.removeEventFilter(MouseEvent.ANY, this);
            }
        }
    }

    protected abstract void executeCreateShapeCommand();

}
