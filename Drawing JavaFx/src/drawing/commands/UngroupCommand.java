package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Group;
import drawing.shapes.Shape;

import java.util.Iterator;

public class UngroupCommand implements Command {

    private Drawing drawing;

    public UngroupCommand(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        Iterator<Shape> liste = drawing.getSelection().iterator();
        while (liste.hasNext()) {
            Shape s = liste.next();
            if (s instanceof Group) {
                Iterator<Shape> grp = ((Group) s).getShapes().iterator();
                while (grp.hasNext())
                    drawing.addShape(grp.next());
                drawing.removeShape(s);
            }
        }
    }

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
