package drawing;

import drawing.shapes.Group;
import drawing.shapes.Shape;
import javafx.scene.control.Label;

/**
 * Created by lewandowski on 12/09/2017.
 */

public class StatusBar extends Label implements DrawingObserver {

	private Drawing drawing;
	
	private String txt = " shape(s)";
	private String shape = "";

	public StatusBar(Drawing drawing) {
		super();
		this.drawing = drawing;
		drawing.handler.addMouseObserver(this);
		this.setText(drawing.nbShapes() + txt);
	}

	@Override
	public void update() {	
		String localString = "";
		if(drawing.getSelection().size() >= 1){
			for(Shape s : drawing.getSelection()){
				if (s instanceof Group) {
					for (Shape z : ((Group) s).getShapes()){
						localString += z.getClass().getSimpleName() + " ";
					}
					shape = " | Group : "+((Group) s).getShapes().size() + " forme : " + localString;
                }else{
                	shape = " | Forme : " + s.getClass().getSimpleName() + " ";
                }
			}
		}else{
            shape = " ";
        }
		
		this.setText(drawing.nbShapes() + txt + shape);
	}
}
