package chart.chartop;

import chart.chartop.person2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class person2Test {

    @Test
    public void testGetCourse() {
        // Arrange
        person2 student = new person2("History", 88);

        // Act
        String course = student.getCourse();

        // Assert
        assertEquals("History", course);
    }

    @Test
    public void testGetScore() {
        // Arrange
        person2 student = new person2("Chemistry", 95);

        // Act
        int score = student.getScore();

        // Assert
        assertEquals(95, score);
    }

    // Add more test cases as needed

}
