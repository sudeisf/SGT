package chart.chartop;

public class User {
    private final String course2;
    private final int score2;

    private final Grade grade;
    private final int gradeValue;

    public User(String course, int score) {
        this.course2 = String.valueOf(course);
        this.score2 = Integer.parseInt(String.valueOf(score));
        this.grade = calculateGrade();
        this.gradeValue = grade.getValue();
    }

    public User(Float introToPro, String course2, int score2, Grade grade, int gradeValue) {
        this.course2 = course2;
        this.score2 = score2;
        this.grade = grade;
        this.gradeValue = gradeValue;
    }

    public enum Grade {
        A(4), B(3), C(2), D(1), F(0);  // Add grade values

        private final int value;

        Grade(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    private int getValue() {
        return 0;
    }

    public Grade calculateGrade() {
        if (score2 >= 85) return Grade.A;
        else if (score2 >= 70) return Grade.B;
        else if (score2 >= 50) return Grade.C;
        else if (score2 >= 40) return Grade.D;
        else return Grade.F;
    }


    public String getCourse() {
        return course2;
    }

    public int getScore() {
        return score2;
    }
    public Grade getGrade() {
        return grade;
    }

    public int getGradeValue() {
        return gradeValue;  // Return the grade value
    }


}
