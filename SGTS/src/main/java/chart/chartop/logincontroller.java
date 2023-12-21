package chart.chartop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class logincontroller implements Initializable {

    @FXML
    private Button Register;

    @FXML
    private void handleButtonClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        regApp page = new regApp();
        page.start(stage);
       
    }

     @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
