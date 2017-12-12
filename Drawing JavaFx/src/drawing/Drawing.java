package drawing;

import drawing.commands.CommandHistory;
import drawing.handlers.DrawingMouseEventHandler;
import drawing.shapes.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by lewandowski on 05/09/2017.
 */
public class Drawing extends Canvas implements Iterable<Shape> {

	private CommandHistory histoire = new CommandHistory();
	
    DrawingMouseEventHandler handler;
    GraphicsContext gc;

    ArrayList<Shape> shapes;

    ArrayList<DrawingObserver> observers = new ArrayList<>();

    public Drawing() {
        super();
        shapes = new ArrayList<>();
        gc = getGraphicsContext2D();
        handler = new DrawingMouseEventHandler(this);
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, handler);
        this.addEventHandler(MouseEvent.MOUSE_RELEASED, handler);
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }

    public int nbShapes() {
        return shapes.size();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        notifyDrawingObservers();
        repaint();
    }

    public void removeShape(Shape shape) {
        if (shapes.remove(shape)) {
            notifyDrawingObservers();
            repaint();
        }
    }

    public void clear() {
        shapes.clear();
        notifyDrawingObservers();
        repaint();
    }

    public void repaint() {
        gc.clearRect(0,0,getWidth(), getHeight());
        for (Shape s: shapes) {
            s.paint(gc);
        }
    }

    public void addDrawingObserver(DrawingObserver observer) {
        observers.add(observer);
    }

    public void removeDrawingObserver(DrawingObserver observer) {
        observers.remove(observer);
    }

    private void notifyDrawingObservers() {
        for (DrawingObserver observer: observers)
            observer.update();
    }

    public Collection<Shape> getSelection() {
        return handler.getSelectedShapes();
    }

    @Override
    public boolean isResizable() {
        return true;
    }
    
    public CommandHistory getCommandHistory(){
    	return histoire;
    }
}
