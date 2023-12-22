package chart.chartop;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class logincontroller implements Initializable {
    public int userId;
    public String username;
    public static String user;
    public static int user_i;
    public static int deptid;
    public static String deptname;

    static String url = "jdbc:sqlite:student.db";

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

         userId = Integer.parseInt(ID.getText());
         username = name.getText();
         user = username;
         user_i = userId;

        try (Connection connection = DriverManager.getConnection(url)){

            
            if (idExists(connection, "Students", "StudentID","FirstName", userId,username)) {
                    String query = "SELECT " + "DepartmentID" + " FROM " + "Students" + " WHERE " + "StudentID" + " = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setInt(1, userId);
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            deptid = resultSet.getInt("DepartmentID");
                            String query2 = "SELECT " + "DepartmentName" + " FROM " + "Department" + " WHERE " + "DepartmentID" + " = ?";
                            try (PreparedStatement preparedStatements = connection.prepareStatement(query2)) {
                            preparedStatements.setInt(1, deptid);
                            try (ResultSet resultSets = preparedStatements.executeQuery()) {
                            deptname = resultSets.getString("DepartmentName");
                            }
                        }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                Stage stage = new Stage();
                ChartDisplayApp page = new ChartDisplayApp();
                page.start(stage);
                
            } else {
                // Create an alert
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Your are not registered yet.");

                // Show the alert
                alert.showAndWait();

                Stage stage = new Stage();
                RegistrationDataEntry page = new RegistrationDataEntry();
                page.start(stage);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Method to check if a specific ID exists in a table
    private static boolean idExists(Connection connection, String tableName, String idColumnName, String nameColumnName, int id, String name) {
        String query = "SELECT COUNT(*) FROM " + tableName + " WHERE " + idColumnName + " = ? AND " + nameColumnName + " = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

     @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

}
