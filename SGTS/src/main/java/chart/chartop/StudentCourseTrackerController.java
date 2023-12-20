package chart.chartop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StudentCourseTrackerController {

    @FXML
    private Button ClickMe;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    public void initialize() {

        ClickMe.setOnAction(e -> handleLogin());
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println(STR."Username: \{username}, Password: \{password}");
    }
}
