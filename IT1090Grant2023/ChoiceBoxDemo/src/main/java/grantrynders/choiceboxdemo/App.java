package grantrynders.choiceboxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application 
{
    ChoiceBox choiceBox = new ChoiceBox();
    VBox mainPane = new VBox();
    Label choiceLabel = new Label();
    Button choiceButton = new Button("Show Choice");
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // create choices
        choiceBox.getItems().addAll("1st Choice", "2nd Choice", "3rd Choice", "4th Choice", "5th Choice");
        choiceBox.setValue("1st Choice");

        // set prefered width of controls
        choiceBox.setPrefWidth(150);
        choiceLabel.setPrefWidth(150);
        choiceButton.setPrefWidth(150);

        // set up main pane
        mainPane.setPadding(new Insets(10,10,10,10));
        mainPane.setSpacing(10);
        mainPane.getChildren().addAll(choiceBox,choiceButton,choiceLabel);

        // set up button event handler
        choiceButton.setOnAction(e -> ShowButtonClick());

        // set up scene and show stage
        Scene scene = new Scene(mainPane);
        primaryStage.setTitle("Choice Box");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void ShowButtonClick() 
    {
        String choice = choiceBox.getValue().toString();
        // retrieve the first character as an integer
        int place = Integer.parseInt(choice.substring(0, 1));
        choiceLabel.setText("You finished number " + place);
    }
    public static void main(String[] args) {
        launch();
    }

}