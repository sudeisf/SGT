package chart.chartop;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CourseEntryController implements Initializable {
    @FXML
    private TextField AlgorithmTextField;

    @FXML
    private Label Algorithms;

    @FXML
    private Label Calculus;

    @FXML
    private TextField CalculusTextFeIld;

    @FXML
    private Label ComputerNewtorks;

    @FXML
    private Label Database_management;

    @FXML
    private Label Deferential_Equations;

    @FXML
    private TextField EquationTextFeild;

    @FXML
    private Label Graph_theory;

    @FXML
    private TextField GthoryTextFeild;

    @FXML
    private TextField IntroToProgrammingTextField;

    @FXML
    private Label Mechanics;

    @FXML
    private TextField NetworkTextFeild;

    @FXML
    private Label Number_theory;

    @FXML
    private Label Optics;

    @FXML
    private Label Physics;

    @FXML
    private TextField PhysicsTextFeild;

    @FXML
    private TextField QmechanicsTextFeild;

    @FXML
    private Label Quantum_mechanics;

    @FXML
    private Label Software_engineering;

    @FXML
    private TextField SweTextFeild;

    @FXML
    private Label Thermodynamics;

    @FXML
    private TextField dataBTextFeild;

    @FXML
    private Label dsa;

    @FXML
    private TextField dsaTextFeild;

    @FXML
    private Label linearAlgebra;

    @FXML
    private TextField linearAlgebraTextFeild;

    @FXML
    private Label magnetism;

    @FXML
    private TextField magnetismTextFeild;

    @FXML
    private TextField mechanicsTextFeild;

    @FXML
    private TextField numTheoryTextFeild;

    @FXML
    private TextField opticsTextFeild;

    @FXML
    private Label programming;

    @FXML
    private Button saveButton;

    @FXML
    private Label semLabel;

    @FXML
    private Label semLabel1;

    @FXML
    private Label semLabel2;

    @FXML
    private Label statistics;

    @FXML
    private TextField statisticsTextFeild;

    @FXML
    private TableView<User2> tableView1;

    @FXML
    private TableColumn<User2, String> tableView1col1;

    @FXML
    private TableColumn<User2, Integer> tableView1col2;

    @FXML
    private TableView<User3> tableView2;

    @FXML
    private TableColumn<User3, String> tableView2col1;

    @FXML
    private TableColumn<User3, Integer> tableView2col2;

    @FXML
    private TableView<User4> tableView3;

    @FXML
    private TableColumn<User4, String> tableView3col1;

    @FXML
    private TableColumn<User4, Integer> tableView3col2;

    @FXML
    private TextField thermodynamicsTexrFeild;


    @FXML
    void nextToLog(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene Scene2 = opticsTextFeild.getScene();
        Stage currentStage = (Stage) Scene2.getWindow();
        currentStage.close();
        LoginApp log =new LoginApp();
        log.start(stage);


    }
    @FXML
    public void nextToLogin(ActionEvent event) throws SQLException {
        // Retrieve data from text fields

        Float introToPro = Float.parseFloat(IntroToProgrammingTextField.getText());
        Float CalculusText = Float.parseFloat(CalculusTextFeIld.getText());
        Float PhysicsText = Float.parseFloat(PhysicsTextFeild.getText());
        Float dsaText = Float.parseFloat(dsaTextFeild.getText());
        float linearAlgebraText = Float.parseFloat(linearAlgebraTextFeild.getText());
        Float magnetismText = Float.parseFloat(magnetismTextFeild.getText());
        Float AlgorithmText = Float.parseFloat(AlgorithmTextField.getText());
        Float EquationText = Float.parseFloat(EquationTextFeild.getText());
        Float opticsText = Float.parseFloat(opticsTextFeild.getText());
        Float dataBText = Float.parseFloat(dataBTextFeild.getText());
        Float numTheoryText = Float.parseFloat(numTheoryTextFeild.getText());
        Float mechanicsText = Float.parseFloat(mechanicsTextFeild.getText());
        Float SWEText = Float.parseFloat(SweTextFeild.getText());
        Float statisticsText = Float.parseFloat(statisticsTextFeild.getText());
        Float thermodynamicsTexr = Float.parseFloat(thermodynamicsTexrFeild.getText());
        Float NetworkText = Float.parseFloat(NetworkTextFeild.getText());
        Float GthoryText = Float.parseFloat(GthoryTextFeild.getText());
        Float QmechanicsText = Float.parseFloat(QmechanicsTextFeild.getText());

        // Add the data to the User2 list
          list.addAll(
                  new User2("Introduction to Programming",introToPro),
                  new User2("Calculus I",CalculusText),
                  new User2("data structure",PhysicsText),
                  new User2("Physics 101",dsaText),
                  new User2("Linear Algebra",linearAlgebraText),
                  new User2("Electricity and Magnetism",magnetismText)
          );
          list2.addAll(
                  new User3("Algorithms",AlgorithmText),
                  new User3("Deferential Equations",EquationText),
                  new User3("Optics",opticsText),
                  new User3("Database management",dataBText),
                  new User3("Number theory",numTheoryText),
                  new User3("Mechanics",mechanicsText)
          );
          list3.addAll(
                  new User4("Software engineering",SWEText),
                  new User4("probablity and statistics",statisticsText),
                  new User4("Thermodynamics",thermodynamicsTexr),
                  new User4("Computer networks",NetworkText),
                  new User4("Graph theory",GthoryText),
                  new User4("Quantum mechanics",QmechanicsText)
          );

        // Update the TableView
        tableView1.setItems(list);
        Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db");


        // Clear the text fields for the next input

    }


    ObservableList<User2> list = FXCollections.observableArrayList();
    ObservableList<User3> list2 = FXCollections.observableArrayList();
    ObservableList<User4> list3 = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableView1col1.setCellValueFactory(new PropertyValueFactory<User2, String>("tableView1col1"));
        tableView1col2.setCellValueFactory(new PropertyValueFactory<User2, Integer>("tableView1col2"));

        tableView2col1.setCellValueFactory(new PropertyValueFactory<User3, String>("tableView2col1"));
        tableView2col2.setCellValueFactory(new PropertyValueFactory<User3, Integer>("tableView2col2"));

        tableView3col1.setCellValueFactory(new PropertyValueFactory<User4, String>("tableView3col1"));
        tableView3col2.setCellValueFactory(new PropertyValueFactory<User4, Integer>("tableView3col2"));

        tableView1.setItems(list);
        tableView2.setItems(list2);
        tableView3.setItems(list3);
    }
    
}
