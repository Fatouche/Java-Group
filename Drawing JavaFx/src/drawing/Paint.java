package drawing;

import drawing.commands.*;
import drawing.handlers.CircleButtonHandler;
import drawing.handlers.CommandButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by lewandowski on 05/09/2017.
 */
public class Paint extends Application {

    private Drawing drawing;
    private Button clearButton;
    private Button circleButton;
    private Button rectangleButton;
    private Button groupButton;
    private Button ungroupButton;
    private Button cloneButton;
    private Button deleteButton;
    private ButtonObserver undoButton;
    private ButtonObserver redoButton;
    private Button text;
    
    public static void main(String[] args) {
        launch(Paint.class, args);
    }

    public Drawing getDrawing() {
        return drawing;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Première application JavaFx");
        BorderPane border = new BorderPane();

        VBox middleBox = new VBox();
        HBox barreBox = new HBox();
        drawing = new Drawing();
        
        drawing.widthProperty().bind(middleBox.widthProperty());
        drawing.heightProperty().bind(middleBox.heightProperty());
        
        middleBox.getChildren().add(drawing);
        VBox.setVgrow(drawing, Priority.ALWAYS);
        border.setCenter(middleBox);

        border.setTop(createButtonsBox());

        StatusBar status = new StatusBar(drawing);
        barreBox.getChildren().addAll(status,StatusBarreException.getInstance());
        
        border.setBottom(barreBox);
        
        Scene scene = new Scene(border, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createButtonsBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        clearButton = new Button("Clear");
        clearButton.setOnAction(new CommandButtonHandler(new ClearCommand(drawing)));

        circleButton = new Button("Cercle");
        circleButton.addEventHandler(ActionEvent.ACTION, new CircleButtonHandler(drawing));

        rectangleButton = new Button("Rectangle");
        rectangleButton.addEventHandler(ActionEvent.ACTION, new RectangleButtonHandler(drawing));

        groupButton = new Button("Group");
        groupButton.setOnAction(new CommandButtonHandler(new GroupCommand(drawing)));

        ungroupButton = new Button("Ungroup");
        ungroupButton.setOnAction(new CommandButtonHandler(new UngroupCommand(drawing)));

        cloneButton = new Button("Clone");
        cloneButton.setOnAction(new CommandButtonHandler(new CloneCommand(drawing)));

        deleteButton = new Button("Delete");
        deleteButton.setOnAction(new CommandButtonHandler(new DeleteCommand(drawing)));

        undoButton = new ButtonObserver("Undo", drawing);
        undoButton.setOnAction(new CommandButtonHandler(new UndoCommand(drawing)));
        
        redoButton = new ButtonObserver("Redo", drawing);
        redoButton.setOnAction(new CommandButtonHandler(new RedoCommand(drawing)));
        
        text = new Button("Text");
        text.setOnAction(new CommandButtonHandler(new AddTextCommand(drawing)));

        hbox.getChildren().addAll(
                clearButton, circleButton, rectangleButton,
                groupButton, ungroupButton, cloneButton,
                deleteButton,undoButton, redoButton, text);
        return hbox;
    }
    
}
