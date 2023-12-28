package grantrynders.choiceboxdemo2;

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
    // declare controls but do not instantiate them yet
    // controls will be instantiated in the CreateMainPane() method
    ChoiceBox choiceBox;
    VBox mainPane;
    Label choiceLabel;
    Button choiceButton;
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        // Since we have moved the GUI code out of start()
        // the start() method is now simple
        // set up scene and show stage
        mainPane = CreateMainPane();
        Scene scene = new Scene(mainPane);
        primaryStage.setTitle("Choice Box");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private VBox CreateMainPane()
    {
        // instantiate controls
        choiceLabel = new Label();
        choiceButton = new Button("Show Choice");
        // set up button event handler
        choiceButton.setOnAction(e -> ShowButtonClick());

        // create choices
        choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("1st Choice", "2nd Choice", "3rd Choice",
                "4th Choice", "5th Choice");
        choiceBox.setValue("1st Choice");

        // set preferred width of controls
        choiceBox.setPrefWidth(150);
        choiceLabel.setPrefWidth(150);
        choiceButton.setPrefWidth(150);

        // set up main pane
        mainPane = new VBox();
        mainPane.setPadding(new Insets(10,10,10,10));
        mainPane.setSpacing(10);
        mainPane.getChildren().addAll(choiceBox,choiceButton,choiceLabel);
        
        return mainPane;
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