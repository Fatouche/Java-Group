package drawing;

import drawing.commands.CommandHistory;

import javafx.scene.control.Button;

public class ButtonObserver extends Button implements DrawingObserver {

    private String name;
    protected Drawing drawing;
    private CommandHistory commandHistory;

    public ButtonObserver(String name,Drawing drawing){
        super(name);
        this.name=name;
        this.drawing = drawing;
        this.commandHistory = drawing.getCommandHistory();
        this.commandHistory.addDrawingObserver(this);
        this.setDisable(true);
        this.setDisable(true);
    }

    @Override
    public void update() {
        if(name ==  "Undo"){
            if(commandHistory.canUndo()){
                this.setDisable(false);
            }else{
                this.setDisable(true);
            }
        }
        if(name == "Redo"){
            if(commandHistory.canRedo()){
                this.setDisable(false);
            }else{
                this.setDisable(true);
            }
        }
    }
}