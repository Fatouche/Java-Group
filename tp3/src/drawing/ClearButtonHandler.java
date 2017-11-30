package drawing;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ClearButtonHandler implements EventHandler<ActionEvent> {

    private Command clear;

    public ClearButtonHandler(Command clean) {
        this.clear = clean;
    }

    @Override
    public void handle(ActionEvent event) {
    	clear.execute();
    }
    
}
