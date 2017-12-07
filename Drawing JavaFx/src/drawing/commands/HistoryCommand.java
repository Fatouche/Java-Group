package drawing.commands;

import java.util.Stack;

public class HistoryCommand{

	private Stack<Command> undo;
	
	public HistoryCommand(){
		this.undo = new Stack<Command>();
	}

	public Command popUndo(){
		if(undo.size() == 0){
			return null;
		}else{
			return undo.pop();
		}
	}
	
	public void pushUndo(Command cmd){
		undo.push(cmd);
	}


	public void clearUndo(){
		undo.clear();
	}
	
	@Override
	public String toString(){
		String str = new String();
		str+= "[Undos] ";
		for(Command c : undo){
			str+= c+" ";
		}	
		str+= "[/Undo]\n ";
		
		return str;
	}
}
