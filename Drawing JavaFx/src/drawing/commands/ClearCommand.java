package drawing.commands;

import drawing.Drawing;
import drawing.ExceptionDrawing;
import drawing.shapes.Group;
import drawing.shapes.Shape;

import java.util.ArrayList;

public class ClearCommand implements Command {
    private Drawing drawing;

    private ArrayList<Shape> clearedShapes;


    public ClearCommand(Drawing drawing) {
        this.drawing = drawing;
        clearedShapes = new ArrayList<Shape>();
        
    }

    @Override
    public void execute() throws ExceptionDrawing {
    	
    	if(drawing.nbShapes()==0){
			throw new ExceptionDrawing("Impossible de clear pas de figure", drawing); 
		}

        for(Shape s : drawing){
        	clearedShapes.add(s);
		}
        
        drawing.clear();
        System.out.println(clearedShapes.size());
        CommandHistory history;
        history = drawing.getCommandHistory();
        history.pushUndo(this);
        history.clearRedos();
		
    }

    @Override
    public void undo() {
		for(Shape s : clearedShapes){
			drawing.addShape(s);
		}
		drawing.repaint();
    }

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for (Shape s : drawing){
            clearedShapes.add(s);
        }
        drawing.clear();
	} 

}
