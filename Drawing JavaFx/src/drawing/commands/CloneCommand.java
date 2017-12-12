package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Shape;

import java.util.Iterator;

public class CloneCommand implements Command {

    private Drawing drawing;

    public CloneCommand(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        Iterator<Shape> it = drawing.getSelection().iterator();
        while (it.hasNext())
            drawing.addShape(it.next().clone());
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
