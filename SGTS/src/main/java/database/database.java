package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    static String url = "jdbc:sqlite:student.db";




    public static void createDatabase() {
        try (Connection con = DriverManager.getConnection(url)) {
            Statement state = con.createStatement();

            String createDepartmentTable = "CREATE TABLE IF NOT EXISTS Department (" +
                    "DepartmentID INTEGER PRIMARY KEY," +
                    "DepartmentName TEXT NOT NULL" +
                    ")";

            state.executeUpdate(createDepartmentTable);

            String createStudentsTable = "CREATE TABLE IF NOT EXISTS Students (" +
                    "StudentID INTEGER PRIMARY KEY," +
                    "FirstName TEXT NOT NULL," +
                    "LastName TEXT NOT NULL," +
                    "Age INTEGER," +
                    "DepartmentID INTEGER," +
                    " FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)" +
                    ")";
            state.executeUpdate(createStudentsTable);

            String createCoursesTable = "CREATE TABLE IF NOT EXISTS Courses (" +
                    "CourseID INTEGER PRIMARY KEY," +
                    "CourseName TEXT NOT NULL," +
                    "Credits INTEGER," +
                    "DepartmentID INTEGER," +
                    " FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)" +
                    ")";
            state.executeUpdate(createCoursesTable);

            String createTeachersTable = "CREATE TABLE IF NOT EXISTS Teachers (" +
                    "TeacherID INTEGER PRIMARY KEY," +
                    "FirstName TEXT NOT NULL," +
                    "LastName TEXT NOT NULL," +
                    "Age INTEGER," +
                    "DepartmentID INTEGER," +
                    " FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)" +
                    ")";

            state.executeUpdate(createTeachersTable);



        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static  void insertData(int id, String fName,String lName, int age)  {
        try {
            Connection con = DriverManager.getConnection(url);
            //Statement state = con.createStatement();
            String insertDataSQL = "INSERT INTO Students (StudentID, FirstName, LastName, Age) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertDataSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, fName);
            preparedStatement.setString(3, lName);
            preparedStatement.setInt(4, age);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private static void insertDepartmentData(Connection connection, int departmentID, String departmentName) {
        String insertDataSQL = "INSERT INTO Department (DepartmentID, DepartmentName) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, departmentID);
            preparedStatement.setString(2, departmentName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void insertStudentData(Connection connection, int studentID, String firstName, String lastName, int age, int departmentID) {
        String insertDataSQL = "INSERT INTO Students (StudentID, FirstName, LastName, Age, DepartmentID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setInt(5, departmentID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void insertCourseData(Connection connection, int courseID, String courseName, int credits, int departmentID) {
        String insertDataSQL = "INSERT INTO Courses (CourseID, CourseName, Credits, DepartmentID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, courseID);
            preparedStatement.setString(2, courseName);
            preparedStatement.setInt(3, credits);
            preparedStatement.setInt(4, departmentID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void insertTeacherData(Connection connection, int teacherID, String firstName, String lastName, int age, int departmentID) {
        String insertDataSQL = "INSERT INTO Teachers (TeacherID, FirstName, LastName, Age, DepartmentID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, teacherID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setInt(5, departmentID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    public static void main(String[] args) {
        createDatabase();
        //displayStudents(url);
        insertData(12,"hamdi","abdu",17);
        // displayStudents(url);
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection(url);

            // Insert sample data into the Department table
            insertDepartmentData(connection, 1, "Computer Science");
            insertDepartmentData(connection, 2, "Mathematics");
            // Add more departments as needed

            // Insert sample data into the Students table
            insertStudentData(connection, 101, "John", "Doe", 20, 1); // Student in Computer Science
            insertStudentData(connection, 102, "Jane", "Smith", 22, 2); // Student in Mathematics
            // Add more students as needed

            // Insert sample data into the Courses table
            insertCourseData(connection, 201, "Introduction to Programming", 3, 1); // Computer Science course
            insertCourseData(connection, 202, "Calculus I", 4, 2); // Mathematics course
            // Add more courses as needed

            // Insert sample data into the Teachers table
            insertTeacherData(connection, 301, "Professor", "Johnson", 40, 1); // Teacher in Computer Science
            insertTeacherData(connection, 302, "Dr.", "Williams", 45, 2); // Teacher in Mathematics
            // Add more teachers as needed

            // Close the connection
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


}

