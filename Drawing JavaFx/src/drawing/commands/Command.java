package drawing.commands;

import drawing.ExceptionDrawing;

public interface Command {

    public void execute() throws ExceptionDrawing;
    
    public void undo();
    
    public void redo();

}
