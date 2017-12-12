package drawing.commands;

import drawing.Drawing;
import drawing.commands.Command;
import drawing.commands.CommandHistory;

public class UndoCommand implements Command
{
    protected CommandHistory history;
    private Drawing drawing;

    public UndoCommand(Drawing drawing)
    {
        this.drawing = drawing;
        this.history = drawing.getCommandHistory();
    }

    public UndoCommand(UndoCommand that)
    {
        this.drawing = that.drawing;
        this.history = that.history;
    }

    @Override
    public void execute()
    {
        Command cmd = history.popUndo();
        if(cmd != null)
        {
            history.pushRedo(cmd);
            cmd.undo();
        }

        System.out.println(history);
    }

    @Override
    public Command clone()
    {
        return new UndoCommand(this);
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