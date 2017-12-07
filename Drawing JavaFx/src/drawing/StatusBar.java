package drawing;

import javafx.scene.control.Label;

/**
 * Created by lewandowski on 12/09/2017.
 */
public class StatusBar extends Label implements DrawingObserver {

    private Drawing drawing;

    private String txt = " shape(s)";

    public StatusBar(Drawing drawing) {
        super();
        this.drawing = drawing;
        drawing.addDrawingObserver(this);
        this.setText(drawing.nbShapes() + txt);
    }

    @Override
    public void update() {
        this.setText(drawing.nbShapes() + txt);
    }
}
