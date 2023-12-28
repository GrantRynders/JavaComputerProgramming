package grantrynders.sliderdemo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application
{
    HBox hsliderHbox;
    VBox vsliderVbox;
    VBox mainPane;
    Slider hSlider, vSlider;
    Label hsliderLabel, vsliderLabel;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        mainPane = CreateMainPane();
        Scene scene = new Scene(mainPane);
        primaryStage.setTitle("Slider Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public VBox CreateMainPane()
    {
        // set up horizontal Hbox for slider and label
        hsliderHbox = CreateHorizontalSlider();
        // set up vertical Vbox for slider and label
        vsliderVbox = CreateVerticalSlider();

        mainPane = new VBox();
        mainPane.setPadding(new Insets(10));
        mainPane.getChildren().addAll(hsliderHbox, vsliderVbox);

        return mainPane;
    }

    public HBox CreateHorizontalSlider()
    {
        hsliderLabel = new Label("0");
        hsliderLabel.setPrefWidth(15);
        // set up a horizontal slider
        hSlider = new Slider();
        hSlider.setPrefWidth(300);
        hSlider.setMin(0);
        hSlider.setMax(20);
        hSlider.setMajorTickUnit(5);
        hSlider.setMinorTickCount(4);
        hSlider.setBlockIncrement(1);
        hSlider.setShowTickLabels(true);
        hSlider.setShowTickMarks(true);
        hSlider.setSnapToTicks(true);
        hSlider.setOrientation(Orientation.HORIZONTAL);
        hSlider.valueProperty().addListener(
                (observable, oldvalue, newvalue) ->
                {
                    // show integer values only
                    hsliderLabel.setText(Integer.toString(newvalue.intValue()));
                });
        // set up horizontal Hbox for slider and label
        hsliderHbox = new HBox();
        hsliderHbox.setPadding(new Insets(10));
        hsliderHbox.setSpacing(10);
        hsliderHbox.getChildren().addAll(hSlider, hsliderLabel);

        return hsliderHbox;
    }

    public VBox CreateVerticalSlider()
    {
        vsliderLabel = new Label("0");
        vsliderLabel.setPrefWidth(100);

        // set up a vertical slider
        vSlider = new Slider();
        vSlider.setPrefWidth(30);
        vSlider.setMin(0);
        vSlider.setMax(20);
        vSlider.setMajorTickUnit(5);
        vSlider.setMinorTickCount(0);
        vSlider.setBlockIncrement(1);
        vSlider.setShowTickLabels(true);
        vSlider.setShowTickMarks(true);
        //vSlider.setSnapToTicks(true);
        vSlider.setOrientation(Orientation.VERTICAL);
        vSlider.valueProperty().addListener(
                (observable, oldvalue, newvalue) ->
                {
                    // show integer values only
                    vsliderLabel.setText(newvalue.toString());
                });
        vsliderVbox = new VBox();
        vsliderVbox.setPadding(new Insets(10));
        vsliderVbox.setSpacing(10);
        vsliderVbox.getChildren().addAll(vSlider, vsliderLabel);

        return vsliderVbox;
    }


    public static void main(String[] args) {
        launch();
    }

}