package chart.chartop;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CourseEntryController implements Initializable {


    @FXML
    private TextField lastname;
    @FXML
    private TextField Firstname;
    @FXML
    private TextField department;
    @FXML
    private TextField gender;
    @FXML
    private TextField studentID;


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

  //this is button function that close the current page and update the new one
    @FXML
    void nextToLog(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene Scene2 = opticsTextFeild.getScene();
        Stage currentStage = (Stage) Scene2.getWindow();
        currentStage.close();
        LoginApp log =new LoginApp();
        log.start(stage);


    }
    // this function saves data in to the database and show case the values inside the tables in gui 
    @FXML
    public void nextToLogin(ActionEvent event) throws SQLException {





        // Retrieve data from text fields

        float introToPro = Float.parseFloat(IntroToProgrammingTextField.getText());
        float CalculusText = Float.parseFloat(CalculusTextFeIld.getText());
        float PhysicsText = Float.parseFloat(PhysicsTextFeild.getText());
        float dsaText = Float.parseFloat(dsaTextFeild.getText());
        float linearAlgebraText = Float.parseFloat(linearAlgebraTextFeild.getText());
        float magnetismText = Float.parseFloat(magnetismTextFeild.getText());

        float AlgorithmText = Float.parseFloat(AlgorithmTextField.getText());
        float EquationText = Float.parseFloat(EquationTextFeild.getText());
        float opticsText = Float.parseFloat(opticsTextFeild.getText());
        float dataBText = Float.parseFloat(dataBTextFeild.getText());
        float numTheoryText = Float.parseFloat(numTheoryTextFeild.getText());
        float mechanicsText = Float.parseFloat(mechanicsTextFeild.getText());

        float SWEText = Float.parseFloat(SweTextFeild.getText());
        float statisticsText = Float.parseFloat(statisticsTextFeild.getText());
        float thermodynamicsTexr = Float.parseFloat(thermodynamicsTexrFeild.getText());
        float NetworkText = Float.parseFloat(NetworkTextFeild.getText());
        float GthoryText = Float.parseFloat(GthoryTextFeild.getText());
        float QmechanicsText = Float.parseFloat(QmechanicsTextFeild.getText());




        String programingLabel = programming.getText();
        String calculusLabel = Calculus.getText();
        String physics = Physics.getText();
        String Dsa = dsa.getText();
        String linearAlgeb = linearAlgebra.getText();
        String magnet = magnetism.getText();

        String algorithm = Algorithms.getText();
        String Dequations = Deferential_Equations.getText();
        String opticslabel = Optics.getText();
        String database_manament_label = Database_management.getText();
        String number_theory_label = Number_theory.getText();
        String mechanicslabel = Mechanics.getText();

        String swelabel = Software_engineering.getText();
        String statisticslabel = statistics.getText();
        String thermolabel = Thermodynamics.getText();
        String network = ComputerNewtorks.getText();
        String g_thorylabel = Graph_theory.getText();
        String Qmechanicslabel = Quantum_mechanics.getText();




        //course entry
        String firstname = Firstname.getText();
        String lastN = lastname.getText();
        int studId = Integer.parseInt(studentID.getText());
        int department_feild = Integer.parseInt(department.getText());
        String Gender = gender.getText();

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
          Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db");
        // first semester
            database.insertScoreData(conn,studId,programingLabel,firstname,introToPro);
            database.insertScoreData(conn,studId,calculusLabel,firstname,CalculusText);
            database.insertScoreData(conn,studId,physics,firstname,PhysicsText);
            database.insertScoreData(conn,studId,Dsa,firstname,dsaText);
            database.insertScoreData(conn,studId,linearAlgeb,firstname,linearAlgebraText);
            database.insertScoreData(conn,studId,magnet,firstname,magnetismText);
  // second semester
            database.insertScoreData(conn,studId,algorithm,firstname,AlgorithmText);
            database.insertScoreData(conn,studId,Dequations,firstname,EquationText);
            database.insertScoreData(conn,studId,opticslabel,firstname,opticsText);
            database.insertScoreData(conn,studId,database_manament_label,firstname,dataBText);
            database.insertScoreData(conn,studId,number_theory_label,firstname,numTheoryText);
            database.insertScoreData(conn,studId,mechanicslabel,firstname,mechanicsText);
//third semester
            database.insertScoreData(conn,studId,swelabel,firstname,SWEText);
            database.insertScoreData(conn,studId,statisticslabel,firstname,statisticsText);
            database.insertScoreData(conn,studId,thermolabel,firstname,thermodynamicsTexr);
            database.insertScoreData(conn,studId,network,firstname,NetworkText);
            database.insertScoreData(conn,studId,g_thorylabel,firstname,GthoryText);
            database.insertScoreData(conn,studId,Qmechanicslabel,firstname,QmechanicsText);


        if (firstname == null || lastname == null || department == null ||  Gender == null) {
            System.err.println("Error: One or more TextField is null.");
            return;
        }


        String url = "jdbc:sqlite:student.db";
// updating the student class
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Students (StudentID, FirstName, LastName, Sex, DepartmentID) VALUES (?,?,?,?,?)")) {

            statement.setInt(1, studId);
            statement.setString(2, firstname);
            statement.setString(3, lastN);
            statement.setString(4, Gender);
            statement.setInt(5, department_feild);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }


        // Update the TableView
        tableView1.setItems(list);
        tableView2.setItems(list2);
        tableView3.setItems(list3);


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
