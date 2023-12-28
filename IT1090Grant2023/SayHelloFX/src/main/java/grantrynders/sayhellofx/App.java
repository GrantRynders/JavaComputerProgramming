package grantrynders.sayhellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application 
{
    // create interface elements (nodes, controls)
    Label nameLabel = new Label("What is your name?");
    TextField nameTextField = new TextField();
    Button greetButton = new Button("Say Hello");
    Label greetLabel = new Label();
    VBox root = new VBox();
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // set up the spacing and padding attributes for the root VBox;
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        // set up reference to button handler
        greetButton.setOnAction(e -> GreetButtonClick());
        // put nodes in the root VBox
        root.getChildren().addAll(nameLabel, nameTextField,
        greetButton, greetLabel);
        // set up scene and show the stage
        primaryStage.setTitle("Greetings");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    private void GreetButtonClick()
    {
        String name = nameTextField.getText();
        greetLabel.setText("Hello " + name);
    }
    public static void main(String[] args) 
    {
        launch();
    }

}