package grantrynders.inchestocentimetersjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application 
{
    // declare and instantiate (make an object from a class) user controls
    Label titleLabel = new Label("Convert inches to centimeters");
    Label inchesLabel = new Label("Enter the number of inches");
    TextField inchesTextField = new TextField();
    Label centimetersLabel = new Label();
    VBox root = new VBox();
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // set up padding and spacing for the root layout pane
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(10);
        // set up reference to event handler
        inchesTextField.setOnAction(e -> ConvertButtonClick());
        // add the nodes to the layout pane
        root.getChildren().addAll(titleLabel, inchesLabel, inchesTextField, centimetersLabel);
        // set the scene and display the stage
        primaryStage.setTitle("Convert");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    private void ConvertButtonClick()
    {
        // conversion factor: 2.54 centimeters per inch
        final double CENTIMETERS_PER_INCH = 2.54;
        double inches, centimeters;
        //get the number of inches
        inches = Double.parseDouble(inchesTextField.getText());
        // convert the inches to centimeters
        centimeters = inches * CENTIMETERS_PER_INCH;
        // print the result
        centimetersLabel.setText(String.format("%.2f centimeters", centimeters));
    }
    public static void main(String[] args) 
    {
        launch();
    }
}