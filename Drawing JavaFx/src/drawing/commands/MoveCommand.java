package drawing.commands;

import drawing.Drawing;
import drawing.shapes.Shape;
import javafx.geometry.Point2D;

public class MoveCommand implements Command {

    private Drawing drawing;

    private Shape shape;
    private Point2D translation;

    public MoveCommand(Drawing drawing, Shape shape, Point2D translation) {
        this.drawing = drawing;
        this.shape = shape;
        this.translation = translation;
    }

    @Override
    public void execute() {
        shape.translate(translation.getX(), translation.getY());
        drawing.repaint();
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
