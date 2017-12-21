package drawing;

import javafx.scene.control.Label;


public class StatusBarreException extends Label{

private static StatusBarreException instance = null;
	
	private String error = "Aucune";
	
	private StatusBarreException() {
		super();
		this.setText(" | Erreur : " + getError());
	}
	
	public static StatusBarreException getInstance() {
		if(instance == null)
			instance = new StatusBarreException();
		return instance;
	}
	
	public void sendError(String txt) {
		this.error = txt;
		update();
	}
	
	public String getError(){
		return error;
	}

	public void update() {
		// TODO Auto-generated method stub
		this.setText(" | Erreur : " + getError());
	}
	
}
