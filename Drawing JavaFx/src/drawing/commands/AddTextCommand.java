package drawing.commands;


import java.util.Iterator;
import java.util.Optional;

import drawing.Drawing;
import drawing.ExceptionDrawing;
import drawing.shapes.Group;
import drawing.shapes.Shape;
import drawing.shapes.ShapeDecorator;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;

public class AddTextCommand implements Command {
	
	protected Drawing drawing;
	Shape currentShape;
	ShapeDecorator shapeDeco;
	Shape testShape;
	
	public AddTextCommand(Drawing drawing){
		this.drawing = drawing;
	}

	@Override
	public void execute() throws ExceptionDrawing {
		// TODO Auto-generated method stub
		Iterator<Shape> it = drawing.getSelection().iterator();
	
		while(it.hasNext())
			testShape = it.next();
		
		currentShape = testShape;
		
		if(currentShape instanceof Group){
			throw new ExceptionDrawing("Impossible d'ajouter du texte sur un groupe", drawing); 
		}
		
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
