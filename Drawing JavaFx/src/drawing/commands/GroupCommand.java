package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Group;
import drawing.shapes.Shape;

import java.util.Collection;

public class GroupCommand implements Command {

    private Drawing drawing;

    public GroupCommand(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        Collection<Shape> liste = drawing.getSelection();
        if (liste.isEmpty())
            return;

        Group g = new Group(liste);
        for (Shape s : liste)
            drawing.removeShape(s);
        drawing.addShape(g);
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
