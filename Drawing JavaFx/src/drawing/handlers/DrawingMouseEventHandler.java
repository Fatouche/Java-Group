package drawing.handlers;

import drawing.Drawing;
import drawing.DrawingObserver;
import drawing.commands.MoveCommand;
import drawing.shapes.Shape;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

/**
 * Created by lewandowski on 05/09/2017.
 */
public class DrawingMouseEventHandler implements EventHandler<MouseEvent>, DrawingObserver {

    private Drawing drawing;

    private double orgSceneX;
    private double orgSceneY;
    private double globalMoveX;
    private double globalMoveY;

    private Shape currentShape;

    private ArrayList<Shape> selectedShapes = new ArrayList<>();

    public DrawingMouseEventHandler(Drawing drawing) {
        this.drawing = drawing;
        drawing.addDrawingObserver(this);
    }

    public ArrayList<Shape> getSelectedShapes() {
        return selectedShapes;
    }

    public void clearSelection() {
        for (Shape s : selectedShapes)
            s.setSelected(false);
        selectedShapes = new ArrayList<>();
    }

    @Override
    public void handle(MouseEvent event) {

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
            globalMoveX = orgSceneX;
            globalMoveY = orgSceneY;


            if (!event.isShiftDown()) {
                clearSelection();
            }

            for (Shape s : drawing) {
                if (s.isOn(new Point2D(event.getX(), event.getY()))) {
                    currentShape = s;
                }
            }
            if (currentShape != null) {
                currentShape.setSelected(true);
                selectedShapes.add(currentShape);
            }
            drawing.repaint();
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();

            if (currentShape != null) {
                currentShape.translate(offsetX, offsetY);
                drawing.repaint();
            }
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            globalMoveX = event.getSceneX() - globalMoveX;
            globalMoveY = event.getSceneY() - globalMoveY;

            if (currentShape != null) {
                if (globalMoveX != 0 && globalMoveY != 0) {
                    System.out.println("move action ");
                    currentShape.translate(-globalMoveX, -globalMoveY);
                    new MoveCommand(drawing, currentShape, new Point2D(globalMoveX, globalMoveY)).execute();
                }
                if (!selectedShapes.contains(currentShape))
                    currentShape.setSelected(false);
            }
            currentShape = null;
            drawing.repaint();

        }
    }

    @Override
    public void update() {
        clearSelection();
    }
}
