package drawing.commands;


import java.util.Iterator;
import java.util.Optional;

import drawing.Drawing;
import drawing.shapes.Shape;
import drawing.shapes.ShapeDecorator;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;

public class AddTextCommand implements Command {
	
	protected Drawing drawing;
	Shape currentShape;
	ShapeDecorator shapeDeco;
	
	public AddTextCommand(Drawing drawing){
		this.drawing = drawing;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Iterator<Shape> it = drawing.getSelection().iterator();
		while(it.hasNext())
			currentShape = it.next();
		
		String textepopup;
        TextInputDialog dialog = new TextInputDialog("ajout text");
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle("Text Ajout");
        dialog.setContentText("Entrée le text pour la figure");
        
        Optional<String> result = dialog.showAndWait();
        
        if (result.isPresent()) {
            textepopup = result.get();
        } else {
            textepopup = "error";
        }
		
		shapeDeco = new ShapeDecorator(currentShape, textepopup);
		CommandHistory history;
        history = drawing.getCommandHistory();
        history.pushUndo(this);
        history.clearRedos();
		
		// Supprime shape et add shapeDecorator
        drawing.removeShape(currentShape);
        drawing.addShape(shapeDeco);
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		drawing.addShape(currentShape);
		drawing.removeShape(shapeDeco);
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		drawing.addShape(shapeDeco);
		drawing.removeShape(currentShape);
	}
	
}
