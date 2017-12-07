package drawing.handlers;

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
        command.execute();
    }
}
