package drawing.commands;

import drawing.Drawing;
import drawing.commands.Command;
import drawing.commands.CommandHistory;

public class RedoCommand implements Command
{
    protected CommandHistory history;
    private Drawing drawing;

    public RedoCommand(Drawing drawing)
    {
        this.drawing = drawing;
        this.history = drawing.getCommandHistory();
    }

    public RedoCommand(RedoCommand that)
    {
        this.drawing = that.drawing;
        this.history = that.history;
    }

    @Override
    public void execute()
    {
        Command cmd = history.popRedo();
        if(cmd != null)
        {
            history.pushUndo(cmd);
            cmd.redo();
        }

        System.out.println(history);
    }

    @Override
    public Command clone()
    {
        return new RedoCommand(this);
    }

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}