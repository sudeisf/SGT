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
                    "Sex TEXT," +
                    "DepartmentID INTEGER," +
                    " FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)" +
                    ")";
            state.executeUpdate(createStudentsTable);

            String createSemesterTable = "CREATE TABLE IF NOT EXISTS Semester (" +
                    "SemesterID INTEGER PRIMARY KEY," +
                    "SemesterName TEXT" +
                    ")";

            state.executeUpdate(createSemesterTable);

            String createCoursesTable = "CREATE TABLE IF NOT EXISTS Courses (" +
                    "CourseID TEXT PRIMARY KEY," +
                    "CourseName TEXT NOT NULL," +
                    "Credits INTEGER," +
                    "SemesterID INTEGER," +
                    "StudentID INTEGER," +
                    " FOREIGN KEY (SemesterID) REFERENCES Semester(SemesterID)," +
                    "FOREIGN KEY (StudentID) REFERENCES Semester(StudentID)" +
                    ")";
            state.executeUpdate(createCoursesTable);

            String createTeachersTable = "CREATE TABLE IF NOT EXISTS Teachers (" +
                    "TeacherID INTEGER PRIMARY KEY," +
                    "FirstName TEXT NOT NULL," +
                    "LastName TEXT NOT NULL," +
                    "Sex TEXT," +
                    "DepartmentID INTEGER," +
                    " FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)" +
                    ")";

            state.executeUpdate(createTeachersTable);

            String createScoreTable = "CREATE TABLE IF NOT EXISTS Scores (" +
                    "StudentID INTEGER," +
                    "CourseName TEXT," +
                    "StudentName TEXT," +
                    "Score INTEGER," +
                    "PRIMARY KEY (StudentID, CourseName)," +
                    " FOREIGN KEY (StudentID) REFERENCES Students(StudentID)," +
                    " FOREIGN KEY (CourseName) REFERENCES Courses(CourseName)" +
                    ")";
            state.executeUpdate(createScoreTable);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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

    private static void insertStudentData(Connection connection, int studentID, String firstName, String lastName, String sex, int departmentID) {
        String insertDataSQL = "INSERT INTO Students (StudentID, FirstName, LastName, Sex, DepartmentID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, sex);
            preparedStatement.setInt(5, departmentID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void insertCourseData(Connection connection, String courseID, String courseName, int credits, int SemesterID) {
        String insertDataSQL = "INSERT INTO Courses (CourseID, CourseName, Credits, SemesterID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setString(1, courseID);
            preparedStatement.setString(2, courseName);
            preparedStatement.setInt(3, credits);
            preparedStatement.setInt(4, SemesterID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void insertTeacherData(Connection connection, int teacherID, String firstName, String lastName, String sex, int departmentID) {
        String insertDataSQL = "INSERT INTO Teachers (TeacherID, FirstName, LastName, Sex, DepartmentID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, teacherID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, sex);
            preparedStatement.setInt(5, departmentID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    private static void insertSemesterData(Connection connection, int semesterID, String semesterName) {
        String insertDataSQL = "INSERT INTO Semester (SemesterID, SemesterName) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, semesterID);
            preparedStatement.setString(2, semesterName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void insertScoreData(Connection connection, int studentID, String courseName, String studentName, int score) {
        String insertScoreData = "INSERT INTO Scores (StudentID, CourseName, StudentName, Score) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertScoreData)) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.setString(2, courseName);
            preparedStatement.setString(3, studentName);
            preparedStatement.setInt(4, score);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createDatabase();

        try {
            // Establish a database connection
            Connection con = DriverManager.getConnection(url);


            insertDepartmentData(con, 1, "Computer Science");
            insertDepartmentData(con, 2, "Mathematics");
            insertDepartmentData(con, 3, "Physics");

            // Insert sample data for Students
            insertStudentData(con, 1, "John", "Doe", "Male", 1);
            insertStudentData(con, 2, "Jane", "Smith", "Female", 2);
            insertStudentData(con, 3, "Bob", "Johnson", "Male", 1);

            // Insert sample data for Courses

            insertCourseData(con, "C001", "Introduction to Programming", 3, 1);
            insertCourseData(con, "C002", "Calculus I", 4, 1);
            insertCourseData(con, "C003", "Physics 101", 4, 1);
            insertCourseData(con, "C004", "Data Structures", 3, 1);
            insertCourseData(con, "C005", "Linear Algebra", 4, 1);
            insertCourseData(con, "C006", "Electricity and Magnetism", 4, 1);

            insertCourseData(con, "C007", "Algorithms", 3, 2);
            insertCourseData(con, "C008", "Differential Equations", 4, 2);
            insertCourseData(con, "C009", "Optics", 4, 2);
            insertCourseData(con, "C010", "Database Management Systems", 3, 2);
            insertCourseData(con, "C011", "Number Theory", 4, 2);
            insertCourseData(con, "C012", "Mechanics", 4, 2);

            insertCourseData(con, "C013", "Software Engineering", 3, 3);
            insertCourseData(con, "C014", "Probability and Statistics", 4, 3);
            insertCourseData(con, "C015", "Thermodynamics", 4, 3);
            insertCourseData(con, "C016", "Computer Networks", 3, 3);
            insertCourseData(con, "C017", "Graph Theory", 4, 3);
            insertCourseData(con, "C018", "Quantum Mechanics", 4, 3);

            // Insert sample data for Teachers
            insertTeacherData(con, 1, "Professor", "Smith", "Male", 1);
            insertTeacherData(con, 2, "Professor", "Johnson", "Male", 2);
            insertTeacherData(con, 3, "Professor", "Brown", "Male", 3);
            insertTeacherData(con, 4, "Instructor", "windy", "Female", 3);
            // Insert sample data for Semesters
            insertSemesterData(con, 1, "Fall 2022");
            insertSemesterData(con, 2, "Spring 2023");
            insertSemesterData(con, 3, "Summer 2023");

            // Insert sample data for Scores with scores
            insertScoreData(con, 1, "Introduction to Programming", "John Doe", 90);
            insertScoreData(con, 2, "Calculus I", "Jane Smith", 85);
            insertScoreData(con, 3, "Physics 101", "Bob Johnson", 78);


            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


}

