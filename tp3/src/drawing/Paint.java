package drawing;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
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
    private ToggleButton groupButton;
    private Button ungroupButton;
    private ToggleButton cloner;
    
    private ClearCommand clear;
    private CloneCommand clo;

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
        drawing = new Drawing();
        drawing.widthProperty().bind(middleBox.widthProperty());
        drawing.heightProperty().bind(middleBox.heightProperty());
        
        clear = new ClearCommand(drawing);
        clo = new CloneCommand(drawing);
        
        middleBox.getChildren().add(drawing);
        VBox.setVgrow(drawing, Priority.ALWAYS);
        border.setCenter(middleBox);

        border.setTop(createButtonsBox());

        MyStatus statusLbl = new MyStatus(drawing);
        border.setBottom(statusLbl);

        Scene scene = new Scene(border, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createButtonsBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        clearButton = new Button("Clear");
        clearButton.setOnAction(new ClearButtonHandler(clear));

        circleButton = new Button("Cercle");
        circleButton.addEventHandler(ActionEvent.ACTION, new CircleButtonHandler(drawing));

        rectangleButton = new Button("Rectangle");
        rectangleButton.addEventHandler(ActionEvent.ACTION, new RectangleButtonHandler(drawing));

        groupButton = new ToggleButton("Group");
        groupButton.addEventHandler(ActionEvent.ACTION, new GroupButtonHandler(drawing));

        ungroupButton = new Button("Ungroup");
        ungroupButton.addEventHandler(ActionEvent.ACTION, new UngroupButtonHandler(drawing));
        
        cloner = new ToggleButton("cloner");
        cloner.addEventHandler(ActionEvent.ACTION, new CloneButtonHandler(clo, drawing));

        hbox.getChildren().addAll(clearButton, circleButton, rectangleButton, groupButton, ungroupButton,cloner );
        return hbox;
    }
}
