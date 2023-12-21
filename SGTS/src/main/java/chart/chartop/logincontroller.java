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

public class logincontroller implements Initializable {

    @FXML
    private Button Register;

    @FXML
    public Button login;

    @FXML
    private TextField ID;

    @FXML
    private TextField name;
    
    @FXML
    private void handleButtonClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        RegistrationDataEntry page = new RegistrationDataEntry();

        page.start(stage);
       
    }
    @FXML
    public void ClosePage() throws IOException {
        Stage stage = new Stage();
        LoginApp log=new LoginApp();
        log.close(stage);
    }

    @FXML
    private void chartPage(ActionEvent event) throws IOException {
          Stage stage = new Stage();
          LoginApp page = new LoginApp();
          page.start(stage);
    }

     @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
