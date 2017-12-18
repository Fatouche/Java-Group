package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Group;
import drawing.shapes.Shape;

import java.util.Collection;

public class GroupCommand implements Command {

    private Drawing drawing;
    private Group g;

    public GroupCommand(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        Collection<Shape> liste = drawing.getSelection();
        if (liste.isEmpty())
            return;

        g = new Group(liste);
        for (Shape s : liste)
            drawing.removeShape(s);
        drawing.addShape(g);
        CommandHistory history;
        history = drawing.getCommandHistory();
        history.pushUndo(this);
        history.clearRedos();
    }

    @Override
    public void undo() {
        drawing.removeShape(g);
        for(Shape s : g.getShapes())
            drawing.addShape(s);
    }

    @Override
    public void redo() {
        drawing.addShape(g);
        for(Shape s : g.getShapes())
            drawing.removeShape(s);
    }
}
