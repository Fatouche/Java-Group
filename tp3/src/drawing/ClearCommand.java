package drawing;

public class ClearCommand extends Command {
	
	public ClearCommand(Drawing drawing) {
		super(drawing);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		drawing.clear();
	}
}
