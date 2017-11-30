package drawing;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class CloneButtonHandler implements EventHandler<Event> {

	private Command clo;
	private Drawing drawing;
	
	public CloneButtonHandler(Command clone, Drawing drawing) {
		this.clo = clone;
		this.drawing = drawing;
	}
	
	@Override
	public void handle(Event event) {
		if (event instanceof ActionEvent) {
			if (event.getSource() instanceof ToggleButton && ((ToggleButton) event.getSource()).isSelected()) {
				drawing.addEventFilter(MouseEvent.ANY, this);
			} else {
				drawing.removeEventFilter(MouseEvent.ANY, this);
				clo.execute();
			}

		}
		if (event instanceof MouseEvent) {
			event.consume();
			if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
				for(Shape figure : drawing){
					if (figure.isOn(new Point2D(((MouseEvent) event).getX(), ((MouseEvent) event).getY()))) {
						figure.Select();
					}
				}
			}
		}
	}

}
