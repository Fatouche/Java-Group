package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Group;
import drawing.shapes.Shape;

import java.util.Iterator;

public class UngroupCommand implements Command {

    private Drawing drawing;
    Shape s;

    public UngroupCommand(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        Iterator<Shape> liste = drawing.getSelection().iterator();
        while (liste.hasNext()) {
            s = liste.next();
            if (s instanceof Group) {
                Iterator<Shape> grp = ((Group) s).getShapes().iterator();
                while (grp.hasNext())
                    drawing.addShape(grp.next());
                drawing.removeShape(s);
            }
        }
        CommandHistory history;
        history = drawing.getCommandHistory();
        history.pushUndo(this);
        history.clearRedos();
    }

    @Override
    public void undo() {
        for(Shape forme : ((Group) s).getShapes())
            drawing.removeShape(forme);
        drawing.addShape(s);

    }

    @Override
    public void redo() {
        for(Shape forme : ((Group) s).getShapes())
            drawing.addShape(forme);
        drawing.removeShape(s);
    }

}
