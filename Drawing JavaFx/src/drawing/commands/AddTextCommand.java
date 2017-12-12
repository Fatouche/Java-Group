package drawing.commands;

import java.util.Iterator;

import drawing.Drawing;
import drawing.shapes.Shape;
import drawing.shapes.ShapeDecorator;

public class AddTextCommand implements Command {
	
	protected Drawing drawing;
	
	public AddTextCommand(Drawing drawing){
		this.drawing = drawing;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Iterator<Shape> it = drawing.getSelection().iterator();
		while (it.hasNext()){
			
		}
			
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
