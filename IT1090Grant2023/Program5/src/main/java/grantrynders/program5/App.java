package grantrynders.program5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.NumberFormat;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;


/**
 * JavaFX App by Grant Rynders
 */
public class App extends Application 
{
    //ui stuff
    GridPane grid;
    Label checkAmountLabel, tipPercentLabel, splitLabel, tipAmountLabel, totalAmountLabel, amountPerPersonLabel;
    Label title = new Label("Tip Calculator");
    Button calculateTipButton;
    ComboBox splitComboBox;
    TextField checkAmountTextField, tipAmountTextField, totalAmountTextField, amountPerPersonTextField;
    Slider tipPercentSlider;
    //values
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    double textFieldWidth = 160; // default textfield value, I thought this looked good, but it's pretty arbitrary
    int defaultSliderValue = 20; // default value of 20%
    @Override
    public void start(Stage stage) throws Exception
    {
        //grid
        grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setMinWidth(textFieldWidth * 2);
        grid.setPrefWidth(textFieldWidth * 2);
        grid.setMaxWidth(800);
        //labels
        checkAmountLabel = new Label("Check Amount");
        tipPercentLabel = new Label("Tip Percent: " + defaultSliderValue + "%");
        splitLabel = new Label("Split");
        tipAmountLabel = new Label("Tip Amount");
        totalAmountLabel = new Label("Total");
        amountPerPersonLabel = new Label("Amount per person");
        //Button
        calculateTipButton = new Button("Calculate Tip");
        calculateTipButton.setMaxWidth(800);
        calculateTipButton.setFocusTraversable(false);
        calculateTipButton.setOnAction(e -> OnClickCalcTip()) ;
        //ComboBox
        splitComboBox = new ComboBox();
        splitComboBox.getItems().addAll("1 Way", "2 Ways", "3 Ways", "4 Ways", "5 Ways");
        splitComboBox.setValue("1 Way"); // sets default value
        splitComboBox.setPrefWidth(textFieldWidth);
        //slider
        tipPercentSlider = new Slider();
        tipPercentSlider.setPrefWidth(300);
        tipPercentSlider.setMin(0);
        tipPercentSlider.setMax(25);
        tipPercentSlider.setMajorTickUnit(5);
        tipPercentSlider.setMinorTickCount(1);
        tipPercentSlider.setBlockIncrement(1);
        tipPercentSlider.setShowTickLabels(true);
        tipPercentSlider.setShowTickMarks(true);
        tipPercentSlider.setSnapToTicks(true);
        tipPercentSlider.setOrientation(Orientation.HORIZONTAL);
        tipPercentSlider.setValue(defaultSliderValue);
        tipPercentSlider.valueProperty().addListener(
                (observable, oldValue, newValue) ->
                {
                    // show integer values only
                    tipPercentLabel.setText("Tip Percent: " + Integer.toString(newValue.intValue()) + "%");
                    //I kindof cheated and just used a percent sign here, since converting the int to a percent seemed like an unneccessary hassle
                });
        //textField
        checkAmountTextField = new TextField();
        checkAmountTextField.setPrefWidth(textFieldWidth);//sets width of field
        checkAmountTextField.setAlignment(Pos.CENTER_RIGHT);//sets alignment of text inside field
        checkAmountTextField.setOnMouseClicked(e -> OnClickResetValues());
        //when the user clicks in the checkAmountTextField, it resets values to defaults, unlike with buttons setOnAction requires you to press the enter key, so a diffferent method was used
        tipAmountTextField = new TextField();
        tipAmountTextField.setPrefWidth(textFieldWidth);
        tipAmountTextField.setEditable(false); // makes field uneditable
        tipAmountTextField.setFocusTraversable(false); // cannot click inside field or edit
        tipAmountTextField.setAlignment(Pos.CENTER_RIGHT);
        totalAmountTextField = new TextField();
        totalAmountTextField.setPrefWidth(textFieldWidth);
        totalAmountTextField.setEditable(false);
        totalAmountTextField.setFocusTraversable(false);
        totalAmountTextField.setAlignment(Pos.CENTER_RIGHT);
        amountPerPersonTextField = new TextField();
        amountPerPersonTextField.setPrefWidth(textFieldWidth);
        amountPerPersonTextField.setEditable(false);
        amountPerPersonTextField.setFocusTraversable(false);
        amountPerPersonTextField.setAlignment(Pos.CENTER_RIGHT);
        //add elements to grid
        grid.addRow(1, title);
        grid.addRow(2, checkAmountLabel,checkAmountTextField);
        grid.addRow(3, tipPercentLabel,tipPercentSlider);
        grid.addRow(4,splitLabel, splitComboBox);
        grid.addRow(5,calculateTipButton);
        grid.addRow(6, tipAmountLabel,tipAmountTextField);
        grid.addRow(7, totalAmountLabel,totalAmountTextField);
        grid.addRow(8, amountPerPersonLabel,amountPerPersonTextField);
        // set alignment of labels and title
        grid.setHalignment(title,HPos.CENTER);
        grid.setHalignment(calculateTipButton,HPos.CENTER);
        grid.setHalignment(checkAmountLabel, HPos.RIGHT);
        grid.setHalignment(tipPercentLabel, HPos.RIGHT);
        grid.setHalignment(splitLabel, HPos.RIGHT);
        grid.setHalignment(checkAmountTextField, HPos.RIGHT);
        grid.setHalignment(tipPercentSlider, HPos.RIGHT);
        grid.setHalignment(splitComboBox, HPos.RIGHT);
        grid.setHalignment(tipAmountLabel, HPos.RIGHT);
        grid.setHalignment(totalAmountLabel, HPos.RIGHT);
        grid.setHalignment(amountPerPersonLabel, HPos.RIGHT);
        grid.setHalignment(tipAmountTextField, HPos.RIGHT);
        grid.setHalignment(totalAmountTextField, HPos.RIGHT);
        grid.setHalignment(amountPerPersonTextField, HPos.RIGHT);
        //columns
        grid.setColumnSpan(title, 2); // title and buttons go across two columns, whereas everything else only one
        grid.setColumnSpan(calculateTipButton, 2);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        grid.getColumnConstraints().addAll(column1, column2);
        //font style
        grid.setStyle("-fx-font: 15 'Comic Sans MS';");
        title.setStyle("-fx-font: 30 'Sans MS';");
        //staging and scene creation
        Scene scene = new Scene(grid);
        stage.setTitle("Tip Calculator");
        stage.setScene(scene);
        stage.show();
    }
    private void OnClickCalcTip()
    {
        //initialization and references
        double checkAmount, tipPercent, tipAmount, totalAmount, split, amountPerPerson;
        checkAmount = Double.parseDouble(checkAmountTextField.getText()); // initial price of order gotten from user input
        tipPercent = tipPercentSlider.getValue();
        String choice = splitComboBox.getValue().toString(); // from comboBox, calculates split by checking string value
        if (choice == "5 Ways")
        {
            split = 5;
        }
        else if (choice == "4 Ways")
        {
            split = 4;
        }
        else if (choice == "3 Ways")
        {
            split = 3;
        }
        else if (choice == "2 Ways")
        {
            split = 2;
        }
        else // 1 way
        {
            split = 1;
        }
        //calculations
        tipAmount = checkAmount * (tipPercent / 100);//tip percent is just a whole double. For example, "20" if it is set to 20% 
        totalAmount = checkAmount + tipAmount;
        amountPerPerson = totalAmount / split;
        //setting the fields equal to the new values, converts to U.S. dollars
        tipAmountTextField.setText(currency.format(tipAmount));
        totalAmountTextField.setText(currency.format(totalAmount));
        amountPerPersonTextField.setText(currency.format(amountPerPerson));
    }
    private void OnClickResetValues()
    {
        //sets all values to null, resets slider and combobox to default values
        checkAmountTextField.setText(null);
        tipAmountTextField.setText(null);
        totalAmountTextField.setText(null);
        amountPerPersonTextField.setText(null);
        tipPercentSlider.setValue(defaultSliderValue);
        splitComboBox.setValue("1 Way");
    }
    public static void main(String[] args) 
    {
        launch();
    }

}