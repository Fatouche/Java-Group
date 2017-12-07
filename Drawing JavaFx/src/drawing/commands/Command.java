package drawing.commands;

public interface Command {

    public void execute();
    
    public void undo();

}
