package chart.chartop;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;


public class RegisterController implements Initializable {
    @FXML
    private Spinner<Integer> spinner;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Create an ObservableList of Integer values (custom values)
        ObservableList<Integer> spinnerValues = FXCollections.observableArrayList(3, 2, 1);

         // Set the Spinner's value factory with the custom values
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(spinnerValues);
        spinner.setValueFactory(valueFactory);
    }
    
}
