package grantrynders.workschedule;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application 
{
    RadioButton morning, afternoon, evening;
    CheckBox monday,tuesday,wednesday,thursday,friday;
    TextArea scheduleText;
    ChoiceBox departmentChoice;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane mainPane = CreateMainPane();

        // assign the main pane to the scene
        Scene scene = new Scene(mainPane);
        // create and show the stage
        primaryStage.setTitle("Work Schedule");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void SubmitButtonClick() 
    {
        String morningLine = "You are scheduled to work from 6 a.m. until 12 noon";
        String afternoonLine = "You are scheduled to work from 12 noon until 6 p.m.";
        String eveningLine = "You are scheduled to work from 6 p.m. until 12 midnight";
        String department = departmentChoice.getValue().toString() + " department";

        // clear previous text
        scheduleText.clear();

        // print shift schedule
        if (morning.isSelected())
            scheduleText.appendText(morningLine + "\n");
        else if (afternoon.isSelected())
            scheduleText.appendText(afternoonLine + "\n");
        else
            scheduleText.appendText(eveningLine + "\n");

        // print department schedule
        scheduleText.appendText("For the " + department + "\n");
        scheduleText.appendText("On the following days:\n");

        // print requested days
        if (monday.isSelected())
            scheduleText.appendText("Monday\n");
        if (tuesday.isSelected())
            scheduleText.appendText("Tuesday\n");
        if (wednesday.isSelected())
            scheduleText.appendText("Wednesday\n");
        if (thursday.isSelected())
            scheduleText.appendText("Thursday\n");
        if (friday.isSelected())
            scheduleText.appendText("Friday");
    }

    private void ClearButtonClick() 
    {
        // reset shift radio button
        morning.setSelected(true);
        // clear check boxes
        monday.setSelected(false);
        tuesday.setSelected(false);
        wednesday.setSelected(false);
        thursday.setSelected(false);
        friday.setSelected(false);
        // clear schedule text area
        scheduleText.clear();
        // reset choice box
        departmentChoice.setValue("Sales");
    }

    private GridPane CreateMainPane()
    {
        // create the panes that make up the main pane
        TitledPane dayPane = CreateDayPane();
        TitledPane shiftPane = CreateShiftPane();
        TitledPane actionPane = CreateActionPane();
        TitledPane schedulePane = CreateSchedulePane();

        // create the grid for the main pane
        GridPane mainPane = new GridPane();
        mainPane.setStyle("-fx-font: 15 'comic sans';");
        mainPane.setPadding(new Insets(15, 15, 15, 15));
        mainPane.setHgap(10);
        mainPane.setVgap(10);

        // add the nodes to the grid
        Label title = new Label("Submit Your Weekly Schedule");
        title.setStyle("-fx-font: 20 'comic sans';");
        mainPane.setHalignment(title, HPos.CENTER); // center the title over the grid
        mainPane.add(title,0,0,3,1);  // title spans 3 columns
        mainPane.addRow(1,dayPane, shiftPane, actionPane);
        mainPane.add(schedulePane,0,2,3,1); // schedule pane spans 3 columns
        // mainPane.setGridLinesVisible(true); // turn on grid lines if debugging
        return mainPane;
    }

    private TitledPane CreateDayPane()
    {
        // create the check boxes
        monday = new CheckBox("Monday");
        tuesday = new CheckBox("Tuesday");
        wednesday = new CheckBox("Wednesday");
        thursday = new CheckBox("Thursday");
        friday = new CheckBox("Friday");

        // create VBox for days
        VBox days = new VBox(10);
        days.getChildren().addAll(monday, tuesday, wednesday, thursday, friday);

        // create weekday titled Pane
        TitledPane dayPane = new TitledPane("Weekday",days);
        dayPane.setCollapsible(false);
        dayPane.setMaxHeight(Double.MAX_VALUE);

        return dayPane;
    }

    public TitledPane CreateShiftPane()
    {
        // create radio buttons
        ToggleGroup shiftGroup = new ToggleGroup();
        morning = new RadioButton("Morning");
        morning.setToggleGroup(shiftGroup);
        afternoon = new RadioButton("Afternoon");
        afternoon.setToggleGroup(shiftGroup);
        evening = new RadioButton("Evening");
        evening.setToggleGroup(shiftGroup);
        morning.setSelected(true);

        // create department choice box
        departmentChoice = new ChoiceBox();
        departmentChoice.getItems().addAll("Sales", "Delivery", "Marketing");
        departmentChoice.setValue("Sales");
        departmentChoice.setMaxWidth(Double.MAX_VALUE);

        // create VBox for choices
        VBox departmentVBox = new VBox(10);
        departmentVBox.getChildren().addAll(morning, afternoon, evening,departmentChoice);

        // create department titled pane
        TitledPane departmentPane = new TitledPane("Department", departmentVBox);
        departmentPane.setCollapsible(false);
        departmentPane.setMaxHeight(Double.MAX_VALUE);

        return departmentPane;
    }

    private TitledPane CreateActionPane()
    {
        // create the buttons
        Button submit = new Button("Submit");
        submit.setMaxWidth(Double.MAX_VALUE);
        submit.setOnAction(e -> SubmitButtonClick());
        Button clear = new Button("Clear");
        clear.setMaxWidth(Double.MAX_VALUE);
        clear.setOnAction(e -> ClearButtonClick());

        // create the VBox for the buttons
        VBox buttonBox = new VBox(10);
        buttonBox.getChildren().addAll(submit, clear);

        // create the titled pane for the button VBox
        TitledPane buttonPane = new TitledPane("Action", buttonBox);
        buttonPane.setCollapsible(false);
        buttonPane.setMaxHeight(Double.MAX_VALUE);

        return buttonPane;
    }

    private TitledPane CreateSchedulePane()
    {
        // create the text area
        scheduleText = new TextArea();
        scheduleText.setEditable(false);  // don't let user enter text
        scheduleText.setPrefWidth(400);

        // create the titled pane
        TitledPane schedulePane = new TitledPane("Schedule", scheduleText);


        return schedulePane;
    }
    
    public static void main(String[] args) 
    {
        launch();
    }

}