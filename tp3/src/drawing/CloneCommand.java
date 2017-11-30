package drawing;

import java.util.ArrayList;

public class CloneCommand extends Command {
	
	public CloneCommand(Drawing drawing) {
		super(drawing);
	}

	public void execute() {
		ArrayList<Shape> figures = new ArrayList<Shape>();
		for(Shape figure : drawing){
			if(figure.isSelected()){	
				figures.add(figure.clone());
			}
		}

		for(Shape figure : figures){
			drawing.addShape(figure);
			drawing.repaint();
		}
	}

}
