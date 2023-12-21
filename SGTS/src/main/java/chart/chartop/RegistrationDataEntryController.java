package chart.chartop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationDataEntryController implements Initializable {
      @FXML
      public Button next1;
    @FXML
    private TextField Department;

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;


    @FXML
    private TextField studID;
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;
      @FXML
      private void nextPage(ActionEvent event) throws IOException {
          Stage stage = new Stage();
          CourseEntryApp page = new CourseEntryApp();

          page.start(stage);

      }
     @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
