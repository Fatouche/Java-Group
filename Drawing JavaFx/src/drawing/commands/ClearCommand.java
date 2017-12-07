package drawing.commands;

import drawing.Drawing;

public class ClearCommand implements Command {

    private Drawing drawing;

    public ClearCommand(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        drawing.clear();
    }

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
