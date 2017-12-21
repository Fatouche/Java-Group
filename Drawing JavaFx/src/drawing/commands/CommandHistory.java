package drawing.commands;

import java.util.ArrayList;
import java.util.Stack;

import drawing.DrawingObserver;

public class CommandHistory  {

    private Stack<Command> undos;
    private Stack<Command> redos;
    ArrayList<DrawingObserver> observers = new ArrayList<>();

    public CommandHistory()
    {
        this.undos = new Stack<Command>();
        this.redos = new Stack<Command>();
    }

    public Command popUndo()
    {
    	notifyDrawingObservers();
        if(undos.size() == 0)
            return null;
        return undos.pop();
    }

    public void pushUndo(Command cmd)
    {
        undos.push(cmd);
        notifyDrawingObservers();
    }

    public Command popRedo()
    {
    	notifyDrawingObservers();
        if(redos.size() == 0)
            return null;
        return redos.pop();
    }

    public void pushRedo(Command cmd)
    {
        redos.push(cmd);
        notifyDrawingObservers();
    }

    public void clearUndos()
    {
        undos.clear();
        notifyDrawingObservers();
    }

    public void clearRedos()
    {
        redos.clear();
        notifyDrawingObservers();
    }

    @Override
    public String toString()
    {
        String str = new String();

        str+= "[Undos] ";
        for(Command c : undos)
            str+= c+" ";
        str+= "[/Undos]\n[Redos] ";
        for(Command c : redos)
            str+= c+" ";
        str+= "[/Redos]\n========================";

        return str;
    }

	public boolean canUndo() {
		return !undos.isEmpty();
	}
	
	public boolean canRedo() {
		return !redos.isEmpty();
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
}
