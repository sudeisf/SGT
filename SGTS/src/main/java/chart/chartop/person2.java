package chart.chartop;
  

public class person2 {
      private static String course3 = null;
      private static int score3 = 0;

    public person2(String course, int score) {
        course3 = course;
        score3 = score;
    }

    public static String getCourse() {
        return course3;
    }

    public static int getScore() {
        return score3;
    }
}
