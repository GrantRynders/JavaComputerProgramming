package grantrynders.calculatepayjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.NumberFormat;
import javafx.geometry.HPos;
/**
 * JavaFX App
 */
public class App extends Application
{
    // declare interface elements
    GridPane grid;
    Label hoursWorkedLabel, payRateLabel, weeklyPayLabel;
    Label title = new Label("Calculate Your Weekly Pay");
    TextField hoursWorkedTextField, payRateTextField, payResultTextField;
    Button calcPayButton, clearButton, exitButton;
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    @Override
    public void start(Stage primaryStage)
    {
        // instantiate interface components
        // instantiate the grid
        grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(10);
        // instantiate labels set width to max value
        hoursWorkedLabel = new Label("Hours Worked");
        hoursWorkedLabel.setMaxWidth(Double.MAX_VALUE);
        hoursWorkedLabel.setAlignment(Pos.CENTER_RIGHT);
        payRateLabel = new Label("Pay Rate");
        payRateLabel.setMaxWidth(Double.MAX_VALUE);
        payRateLabel.setAlignment(Pos.CENTER_RIGHT);
        weeklyPayLabel = new Label("Weekly Pay");
        weeklyPayLabel.setMaxWidth(Double.MAX_VALUE);
        weeklyPayLabel.setAlignment(Pos.CENTER_RIGHT);
        // create text fields set preferred width
        // set preferred text field widths
        double textFieldWidth = 100;
        hoursWorkedTextField = new TextField();
        hoursWorkedTextField.setPrefWidth(textFieldWidth);
        hoursWorkedTextField.setAlignment(Pos.CENTER_RIGHT);
        payRateTextField = new TextField();
        payRateTextField.setPrefWidth(textFieldWidth);
        payRateTextField.setAlignment(Pos.CENTER_RIGHT);
        payResultTextField = new TextField();
        payResultTextField.setFocusTraversable(false);
        payResultTextField.setPrefWidth(textFieldWidth);
        payResultTextField.setAlignment(Pos.CENTER_RIGHT);
        payResultTextField.setEditable(false);
        // create buttons set width to max value
        // calculate pay button
        calcPayButton = new Button("Calculate Pay");
        calcPayButton.setMaxWidth(Double.MAX_VALUE);
        calcPayButton.setFocusTraversable(false);
        calcPayButton.setOnAction(e -> CalcPayClick()) ;
        // create clear button
        clearButton = new Button("Clear");
        clearButton.setMaxWidth(Double.MAX_VALUE);
        clearButton.setFocusTraversable(false);
        clearButton.setOnAction(e -> clearButtonClick()) ;
        // create exit button
        exitButton = new Button("Exit");
        exitButton.setMaxWidth(Double.MAX_VALUE);
        exitButton.setFocusTraversable(false);
        exitButton.setOnAction(e -> primaryStage.close()) ;
        // Add interface components to grid
        grid.add(title, 0, 0, 3, 1);
        grid.setHalignment(title,HPos.CENTER);
        grid.addRow(1, hoursWorkedLabel,hoursWorkedTextField, calcPayButton);
        grid.addRow(2, payRateLabel,payRateTextField, clearButton);
        grid.addRow(3,weeklyPayLabel, payResultTextField, exitButton);
        Scene scene = new Scene(grid);
        // you can set the font for the grid by setting the style
        // property of the grid
        grid.setStyle("-fx-font: 15 'Comic Sans MS';");
        primaryStage.setTitle("Calculate Pay");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args)
    {
        launch(args);
    }
    private void CalcPayClick()
    {
        double hours, rate, pay;
        hours = Double.parseDouble(hoursWorkedTextField.getText());
        rate = Double.parseDouble(payRateTextField.getText());
        if (hours > 40)
        pay = (40 * rate) + (hours - 40) * rate * 1.5;
        else
        pay = hours * rate;
        payResultTextField.setText(currency.format(pay));
    }
    private void clearButtonClick()
    {
        hoursWorkedTextField.clear();
        payRateTextField.clear();
        payResultTextField.clear();
    }
}