package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Shape;

import java.util.ArrayList;
import java.util.Iterator;

public class DeleteCommand implements Command {

    private Drawing drawing;
    private ArrayList<Shape> delShapes =new ArrayList<Shape>();
    private ArrayList<Shape> addShapes =new ArrayList<Shape>();
    Iterator<Shape> it;

    public DeleteCommand(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {
        it = drawing.getSelection().iterator();
        while (it.hasNext()) {
            Shape s = it.next();
            delShapes.add(s);
            drawing.removeShape(s);
        }
        CommandHistory history;
        history = drawing.getCommandHistory();
        history.pushUndo(this);
        history.clearRedos();
    }

    @Override
    public void undo() {
        addShapes.clear();
        for (Shape s : delShapes) {
            drawing.addShape(s);
            addShapes.add(s);
        }
        delShapes.clear();
    }

    @Override
    public void redo() {
        delShapes.clear();
        for(Shape s : addShapes){
            drawing.removeShape(s);
            delShapes.add(s);
        }
        System.out.println(addShapes);
        addShapes.clear();

    }
}
