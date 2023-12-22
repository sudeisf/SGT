package chart.chartop;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationDataEntryController implements Initializable {

        @FXML
        private TextField first_name;

        @FXML
        private TextField last_name;

        @FXML
        private TextField Department;

        @FXML
        private TextField studID;

        @FXML
        private TextField Gender;

        @FXML
        private void nextPage(ActionEvent event) throws IOException {
            // Check if any TextField is null
            if (first_name == null || last_name == null || Department == null || studID == null || Gender == null) {
                System.err.println("Error: One or more TextField is null.");
                return;
            }

            // Store TextField data in variables to insert into the database
            String firstNameText = first_name.getText();
            String lastNameText = last_name.getText();

            // Validate and parse integer inputs
            int DepartmentText = parseInteger(Department.getText());
            int studIDText = parseInteger(studID.getText());

            // Check if parsing failed
            if (DepartmentText == -1 || studIDText == -1) {
                System.err.println("Error: Invalid integer input.");
                return;
            }

            String GenderText = Gender.getText();

            String url = "jdbc:sqlite:student.db";

            try (Connection connection = DriverManager.getConnection(url);
                 PreparedStatement statement = connection.prepareStatement(
                         "INSERT INTO Students (StudentID, FirstName, LastName, Sex, DepartmentID) VALUES (?,?,?,?,?)")) {

                statement.setInt(1, studIDText);
                statement.setString(2, firstNameText);
                statement.setString(3, lastNameText);
                statement.setString(4, GenderText);
                statement.setInt(5, DepartmentText);

                statement.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }

            Stage stage = new Stage();
            CourseEntryApp page = new CourseEntryApp();
            page.start(stage);
        }

        // Helper method to safely parse integers
        private int parseInteger(String input) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                return -1; // Indicates parsing failure
            }
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

