package grantrynders.buttongrid;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

    Label resultsLabel;
    VBox mainPane;
    HBox resultsHBox;
    GridPane buttonPane;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // set up panes
        mainPane = new VBox(10);
        mainPane.setPadding(new Insets(10,10,10,10));
        resultsHBox = new HBox();
        resultsLabel = new Label();
        resultsLabel.setFont(Font.font("Courier New", 20));
        resultsHBox.getChildren().add(resultsLabel);
        buttonPane = CreateButtonGrid();
        mainPane.getChildren().addAll(buttonPane, resultsHBox);

        Scene scene = new Scene(mainPane);

        primaryStage.setTitle("Buttons Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private GridPane CreateButtonGrid()
    {
        // brute force way to create a button grid.
        Button button0 = new Button("0");
        button0.setOnAction(e -> letterClicked(e));
        Button button1 = new Button("1");
        button1.setOnAction(e -> letterClicked(e));
        Button button2 = new Button("2");
        button2.setOnAction(e -> letterClicked(e));
        Button button3 = new Button("3");
        button3.setOnAction(e -> letterClicked(e));
        Button button4 = new Button("4");
        button4.setOnAction(e -> letterClicked(e));
        Button button5 = new Button("5");
        button5.setOnAction(e -> letterClicked(e));
        Button button6 = new Button("6");
        button6.setOnAction(e -> letterClicked(e));
        Button button7 = new Button("7");
        button7.setOnAction(e -> letterClicked(e));
        Button button8 = new Button("8");
        button8.setOnAction(e -> letterClicked(e));
        Button button9 = new Button("9");
        button9.setOnAction(e -> letterClicked(e));


        GridPane buttonPane = new GridPane();
        buttonPane.setStyle("{-fx-font:'Comic Sans MS'; -fx-font-size: 30}");

        buttonPane.setHgap(5);
        buttonPane.setVgap(10);

        buttonPane.addRow(0, button1,button2,button3);
        buttonPane.addRow(1, button4,button5,button6);
        buttonPane.addRow(2, button7, button8, button9);

        return buttonPane;
    }

    private GridPane CreateButtonGrid2()
    {
        // better way to create a button grid.
        String digits[] = {"1","2","3","4","5",
                "6","7","8","9"};
        GridPane buttonPane = new GridPane();
        Button button;
        int col = 0;
        int row = 0;

        buttonPane.setHgap(5);
        buttonPane.setVgap(10);
        buttonPane.setStyle("{-fx-font:'Courier New'; -fx-font-size: 30}");

        for (String digit: digits)
        {
            button = new Button(digit);
            button.setMaxWidth(Double.MAX_VALUE); // make all buttons the same size
            buttonPane.add(button, col++, row);
            button.setOnAction(e -> letterClicked(e));
            if (col == 3)
            {
                row++;
                col = 0;
            }
        }
        return buttonPane;

    }

    private void letterClicked(ActionEvent e)
    {
        Button bt = (Button) e.getSource();

        resultsLabel.setText("You pressed " + bt.getText());
    }
    
    public static void main(String[] args) {
        launch();
    }

}