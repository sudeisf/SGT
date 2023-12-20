package chart.chartop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;


import java.lang.reflect.GenericSignatureFormatError;
import java.net.URL;
import java.util.ResourceBundle;

public class chartController implements Initializable {

    @FXML
    public BarChart<String,Integer> ChartBox;

    @FXML
    public TableView<User> table1;
    public TableColumn<User,String> course;
    @FXML
    public TableColumn<User,Integer> score;

    @FXML
    private void handleMouseClicked(MouseEvent event) {
        // Clear existing data in the chart
        ChartBox.getData().clear();

        // Iterate through all rows in the table
        for (User user : table1.getItems()) {
            // Create a series for each user
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(user.getCourse());
            series.getData().add(new XYChart.Data<>(user.getCourse(), user.getScore()));

            // Add the series to the chart
            ChartBox.getData().add(series);
        }

        // Set the bar and category gaps
        ChartBox.setBarGap(2.0);
        ChartBox.setCategoryGap(2.0);
    }


    ObservableList<User> list = FXCollections.observableArrayList(
            new User("Operating system",60),
            new User("Computer organization",93),
            new User("Statistics and prob",70),
            new User("Data structure and algorithm",85),
            new User("Object oriented",66),
            new User("Networking",94)




    );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


  XYChart.Series<String, Integer> series1 = new XYChart.Series<>();

        course.setCellValueFactory(new PropertyValueFactory<User,String>("course"));
        score.setCellValueFactory(new PropertyValueFactory<User, Integer>("score"));

      table1.setItems(list);


    }
}