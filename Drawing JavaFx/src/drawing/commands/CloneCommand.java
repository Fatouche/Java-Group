package drawing.commands;

import drawing.Drawing;
import drawing.ExceptionDrawing;
import drawing.shapes.Shape;

import java.util.Iterator;

public class CloneCommand implements Command {

    private Drawing drawing;
    Shape figure;

    public CloneCommand(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() throws ExceptionDrawing {
        Iterator<Shape> it = drawing.getSelection().iterator();
        
        if(drawing.getSelection().size()==0){
			throw new ExceptionDrawing("Impossible de clonner il faut selectionner un figure", drawing); 
		}
        
        while (it.hasNext()){
            figure = it.next().clone();
            drawing.addShape(figure);
        }
            
    }

    @Override
    public void undo() {
        drawing.removeShape(figure);

    }

    @Override
    public void redo() {
        drawing.addShape(figure);
    }
}
