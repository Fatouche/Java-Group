package drawing;

public class ExceptionDrawing extends Exception {
	
	private static final long serialVersionUID = 1L;
	private StatusBarreException statusError;
	private String error;
	
	public ExceptionDrawing(String text, Drawing drawing) {
		super(text);
		statusError = StatusBarreException.getInstance();
		this.error = text;

	}

	public void Show() {
		// TODO Auto-generated method stub
		statusError.sendError(error);
	}
}