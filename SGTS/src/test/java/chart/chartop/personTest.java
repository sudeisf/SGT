package chart.chartop;

import chart.chartop.person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class personTest {

    @Test
    public void testGetCourse() {
        // Arrange
        person student = new person("Math", 90);

        // Act
        String course = student.getCourse();

        // Assert
        assertEquals("Math", course);
    }

    @Test
    public void testGetScore() {
        // Arrange
        person student = new person("Physics", 75);

        // Act
        int score = student.getScore();

        // Assert
        assertEquals(75, score);
    }

    // Add more test cases as needed

}
