package chart.chartop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class logincontroller implements Initializable {

    public static int userId;
    public static String username;
    public static String user;
    public static int user_i;
    public static int deptid;
    public static String deptname;
    public static boolean check = true;

    static String url = "jdbc:sqlite:student1.db";

    @FXML
    private Button Register;

    @FXML
    public Button login;

    @FXML
    private TextField ID;

    @FXML
    private TextField name;

    // chart page
    @FXML
    private void chartPage(ActionEvent event) throws IOException {
        username = name.getText();
        try (Connection connection = DriverManager.getConnection(url)) {
            userId = Integer.parseInt(ID.getText());
        } catch (Exception e) {
            check = false;
            Alert alert3 = new Alert(AlertType.INFORMATION);
            alert3.setTitle("Information Dialog");
            alert3.setHeaderText(null);
            alert3.setContentText("You Entered invalid ID! Please try again");
            alert3.showAndWait();
        }

        user = username;
        user_i = userId;

        //
        try (Connection connection = DriverManager.getConnection(url)) {

            if (idExists(connection, "Students", "StudentID", "FirstName", userId, username)) {
                String query = "SELECT " + "DepartmentID" + " FROM " + "Students" + " WHERE " + "StudentID" + " = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, userId);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        deptid = resultSet.getInt("DepartmentID");
                        String query2 = "SELECT " + "DepartmentName" + " FROM " + "Department" + " WHERE "
                                + "DepartmentID" + " = ?";
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


            } else {
                if (check) {
                    // Create an alert
                    if (isInteger(username)) {
                        Alert alert2 = new Alert(AlertType.INFORMATION);
                        alert2.setTitle("Information Dialog");
                        alert2.setHeaderText(null);
                        alert2.setContentText("You Entered invalid name! Please try again");
                        alert2.showAndWait();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Your are not registered yet.");

                        // Show the alert
                        alert.showAndWait();

                        Stage stage = new Stage();
                        CourseEntryApp page = new CourseEntryApp();
                        page.start(stage);
                    }

                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        Stage stage = new Stage();
        Scene scene = ID.getScene();
        Stage currentStage = (Stage) scene.getWindow();
        currentStage.close();
        ChartDisplayApp page = new ChartDisplayApp();
        page.start(stage);
    }

    // Method to check if a specific ID exists in a table
    private static boolean idExists(Connection connection, String tableName, String idColumnName, String nameColumnName,
            int id, String name) {
        String query = "SELECT COUNT(*) FROM " + tableName + " WHERE " + idColumnName + " = ? AND " + nameColumnName
                + " = ?";
        ;
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

    public void registerPage() throws IOException {
        Stage stage = new Stage();
        Scene scene = ID.getScene();
        CourseEntryApp corse = new CourseEntryApp();
        Stage currentStage = (Stage) scene.getWindow();
        currentStage.close();
        corse.start(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
