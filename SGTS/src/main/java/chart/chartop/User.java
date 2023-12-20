package chart.chartop;

public class User {
      private final String course;
      private final int score;

    public User(String course, int score) {
        this.course = course;
        this.score = score;
    }

    public String getCourse() {
        return course;
    }

    public int getScore() {
        return score;
    }
}
