package grantrynders.fahrenheittocelciusfx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application 
{
    // create interface elements
    Label title = new Label("Fahrenheit to Celsius Conversion");
    Label fahrenheitLabel = new Label("Fahrenheit Temperature");
    Label celsiusLabel = new Label("Celsius Temperature");
    TextField fahrenheitTextField = new TextField();
    TextField celsiusTextField = new TextField();
    GridPane root = new GridPane();
    @Override
    public void start(Stage primaryStage) 
    {
        // set up padding and gaps for the grid
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(15);
        root.setVgap(15);
        //root.setGridLinesVisible(true);
        // place labels and text fields in the grid
        // set up the title row
        root.add(title,0,0,2,1);
        root.setHalignment(title, HPos.CENTER);
        // set up remaining rows
        root.addRow(1, fahrenheitLabel, fahrenheitTextField);
        root.addRow(2, celsiusLabel, celsiusTextField);
        // set up the action event for the fahrenheitTextField
        fahrenheitTextField.setOnAction(e -> ConvertTemperature());
        // set the scene and show the stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Temperature Conversion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void ConvertTemperature()
    {
        double fahrenheitTemp = Double.parseDouble(fahrenheitTextField.getText());
        double celsiusTemp = (fahrenheitTemp - 32) * (5.0/9);
        celsiusTextField.setText(String.format("%.2f", celsiusTemp));
    }
    public static void main(String[] args) 
    {
        launch();
    }
}