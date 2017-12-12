package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Shape;

import java.util.Iterator;

public class DeleteCommand implements Command {

    private Drawing drawing;

    public DeleteCommand(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        Iterator<Shape> it = drawing.getSelection().iterator();
        while (it.hasNext())
            drawing.removeShape(it.next());
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
