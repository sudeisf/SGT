package chart.chartop;

public class person {
    private final String course3;
    private final int score3;

    // private final Grade grade;
    // private final int gradeValue;

    // public enum Grade {
    //     A(4), B(3), C(2), D(1), F(0);  // Add grade values

    //     private final int value;

    //     Grade(int value) {
    //         this.value = value;
    //     }

    //     public int getValue() {
    //         return value;
    //     }
    // }

    public person(String course, int score) {
        this.course3 = course;
        this.score3 = score;
        // this.grade = calculateGrade();
        // this.gradeValue = grade.getValue();
    }

    // private int getValue() {
    //     return 0;
    // }

    // public Grade calculateGrade() {
    //     if (score3 >= 85) return Grade.A;
    //     else if (score3 >= 70) return Grade.B;
    //     else if (score3 >= 50) return Grade.C;
    //     else if (score3 >= 40) return Grade.D;
    //     else return Grade.F;
    // }


    public String getCourse() {
        return course3;
    }

    public int getScore() {
        return score3;
    }
    // public Grade getGrade() {
    //     return grade;
    // }

    // public int getGradeValue() {
    //     return gradeValue;  // Return the grade value
    // }


}