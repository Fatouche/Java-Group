package drawing;

import javafx.scene.control.Label;

public class MyStatus extends Label implements DrawingObserver {

    Drawing drawing;

    public MyStatus(Drawing drawing) {
        this.drawing = drawing;
        drawing.addDrawingOberser(this);
        this.setText(drawing.nbShapes() + " shape(s)");
    }

    @Override
    public void update() {
        this.setText(drawing.nbShapes() + " shape(s)");
    }
}
