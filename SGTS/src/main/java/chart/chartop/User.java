package chart.chartop;

//The User class represents a student with their course, score, grade, and grade value.

public class User {

    // Instance variables to store course, score, grade, and grade value
    private final String course2;
    private final int score2;
    //private final Grade grade;
    //private final int gradeValue;

    /**
     * Constructor to create a User object based on course and score.
     * The grade and grade value are calculated automatically.
     */
    public User(String course, int score) {
        this.course2 = String.valueOf(course);
        this.score2 = Integer.parseInt(String.valueOf(score));
        //this.grade = calculateGrade();
        //this.gradeValue = grade.getValue();
    }

    //Constructor to create a User object with all parameters.

   /*  public User(String course2, int score2, Grade grade, int gradeValue) {
        this.course2 = course2;
        this.score2 = score2;
        this.grade = grade;
        this.gradeValue = gradeValue;
    }*/

    // /**
    //  * Enum representing the grades along with their values.
    //  */
    // public enum Grade {
    //     A(4), B(3), C(2), D(1), F(0);  // Grades with their corresponding values

    //     private final int value;

    //     Grade(int value) {
    //         this.value = value;
    //     }

    //     //Getter method to retrieve the value of the grade.

    //     public int getValue() {
    //         return value;
    //     }
    // }

    // //Method to calculate the grade based on the score.

    // public Grade calculateGrade() {
    //     if (score2 >= 85) return Grade.A;
    //     else if (score2 >= 70) return Grade.B;
    //     else if (score2 >= 50) return Grade.C;
    //     else if (score2 >= 40) return Grade.D;
    //     else return Grade.F;
    // }

    //Getter method to retrieve the course.
    public String getCourse() {
        return course2;
    }

    //Getter method to retrieve the score.

    public int getScore() {
        return score2;
    }

    //Getter method to retrieve the grade.

    // public Grade getGrade() {
    //     return grade;
    // }

    //Getter method to retrieve the grade value.

    // public int getGradeValue() {
    //     return gradeValue;
    // }
}
