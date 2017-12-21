package drawing.handlers;

import drawing.ExceptionDrawing;
import drawing.commands.Command;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class CommandButtonHandler implements EventHandler<ActionEvent> {

    private Command command;

    public CommandButtonHandler(Command command) {
        this.command = command;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
			command.execute();
		} catch (ExceptionDrawing e) {
			// TODO Auto-generated catch block
			e.Show();
		}
    }
}
