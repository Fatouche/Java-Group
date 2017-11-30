package drawing;

public abstract class Command {

	protected Drawing drawing; 
	
	public Command(Drawing drawing) {
		// TODO Auto-generated constructor stub
		this.drawing = drawing;
	}

	public abstract void execute();
	
	
}
