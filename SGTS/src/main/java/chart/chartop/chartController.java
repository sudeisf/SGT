package chart.chartop;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

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

public class chartController implements Initializable {

    @FXML
    public BarChart<String,Integer> ChartBox;

    @FXML
    private Label Mean;

    @FXML
    private Label Median;

    @FXML
    public TableView<User> table1;
    
    public TableColumn<User,String> course;
    @FXML
    public TableColumn<User,Integer> score;

    @FXML
    private void handleMouseClicked(MouseEvent event) {
        // Clear existing data in the chart
        ChartBox.getData().clear();
        // Number of course the student take
        final int  numcourse = 6;
        // variable for storing the sum
        int sum = 0;
        // Array to store the score of all course
        int[] sort = new int[numcourse];
        int i = 0;
      
        // Iterate through all rows in the table
        for (User user : table1.getItems()) {
            // Create a series for each user
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(user.getCourse());
            series.getData().add(new XYChart.Data<>(user.getCourse(), user.getScore()));
            
            // Add the series to the chart
            ChartBox.getData().add(series);

            // Adding the score
            sum = sum + user.getScore();

            // Appending the score into the array
            sort[i] = user.getScore();
            i++;

        }
        Arrays.sort(sort);
        // Variable to store the median
        float median = (float)((sort[sort.length/2-1]) + (sort[sort.length/2]))/2;


        // variable for storing the mean
        int mean_value = sum/numcourse;

        // Displaying the Mean and Median
        Mean.setText(Integer.toString(mean_value));
        Median.setText(Float.toString(median));



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