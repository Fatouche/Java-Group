package drawing;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class GroupButtonHandler implements EventHandler<Event> {

    private Drawing drawing;
    private Command group;

    public GroupButtonHandler(Command g,Drawing drawing) {
        this.drawing = drawing;
        this.group = g;
    }

    @Override
    public void handle(Event event) {

        if (event instanceof ActionEvent) {
            if (event.getSource() instanceof ToggleButton && ((ToggleButton) event.getSource()).isSelected()) {
                drawing.addEventFilter(MouseEvent.ANY, this);
            } else {
                drawing.removeEventFilter(MouseEvent.ANY, this);
                group.execute();
            }
        }
        if (event instanceof MouseEvent) {
            event.consume();

            if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                for (Shape shape : drawing) {
                    if (shape.isOn(new Point2D(((MouseEvent) event).getX(), ((MouseEvent) event).getY()))) {
                        shape.Select();
                    }
                }
            }
        }
    }
}
