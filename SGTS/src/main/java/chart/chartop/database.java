package chart.chartop;


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
                    "CourseID INTEGER PRIMARY KEY," +
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
                    "CourseID INTEGER," +
                    "StudentName TEXT," +
                    "Score float," +
                    "PRIMARY KEY (StudentID, CourseID)," +
                    " FOREIGN KEY (StudentID) REFERENCES Students(StudentID)," +
                    " FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)" +
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

    private static void insertCourseData(Connection connection, int courseID, String courseName, int credits, int SemesterID) {
        String insertDataSQL = "INSERT INTO Courses (CourseID, CourseName, Credits, SemesterID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, courseID);
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
    public static void insertSemesterData(Connection connection, int semesterID, String semesterName) {
        String insertDataSQL = "INSERT INTO Semester (SemesterID, SemesterName) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, semesterID);
            preparedStatement.setString(2, semesterName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void insertScoreData(Connection connection, int studentID, String courseName, String studentName, Float score) {
        String insertScoreData = "INSERT INTO Scores (StudentID, CourseName, StudentName, Score) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertScoreData)) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.setString(2, courseName);
            preparedStatement.setString(3, studentName);
            preparedStatement.setFloat(4, score);
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


            // Insert sample data for Courses

            insertCourseData(con,1, "Introduction to Programming", 3, 1);
            insertCourseData(con,2 , "Calculus I", 4, 1);
            insertCourseData(con,3 , "Physics 101", 4, 1);
            insertCourseData(con,4 , "Data Structures", 3, 1);
            insertCourseData(con,5 , "Linear Algebra", 4, 1);
            insertCourseData(con, 6, "Electricity and Magnetism", 4, 1);

            insertCourseData(con,7 , "Algorithms", 3, 2);
            insertCourseData(con, 8, "Differential Equations", 4, 2);
            insertCourseData(con, 9, "Optics", 4, 2);
            insertCourseData(con, 10, "Database Management Systems", 3, 2);
            insertCourseData(con, 11, "Number Theory", 4, 2);
            insertCourseData(con, 12, "Mechanics", 4, 2);

            insertCourseData(con,13 , "Software Engineering", 3, 3);
            insertCourseData(con, 14, "Probability and Statistics", 4, 3);
            insertCourseData(con, 15, "Thermodynamics", 4, 3);
            insertCourseData(con,16 , "Computer Networks", 3, 3);
            insertCourseData(con,17 , "Graph Theory", 4, 3);
            insertCourseData(con,18 , "Quantum Mechanics", 4, 3);

            // Insert sample data for Teachers
            insertTeacherData(con, 1, "Professor", "Smith", "Male", 1);
            insertTeacherData(con, 2, "Professor", "Johnson", "Male", 2);
            insertTeacherData(con, 3, "Professor", "Brown", "Male", 3);
            insertTeacherData(con, 4, "Instructor", "windy", "Female", 3);
            // Insert sample data for Semesters
            insertSemesterData(con, 1, "Fall 2022");
            insertSemesterData(con, 2, "Spring 2023");
            insertSemesterData(con, 3, "Summer 2023");


            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


}


