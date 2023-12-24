package chart.chartop;

import chart.chartop.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testGetCourse() {
        // Arrange
        User user = new User("Math", 90);

        // Act
        String course = user.getCourse();

        // Assert
        assertEquals("Math", course);
    }

    @Test
    public void testGetScore() {
        // Arrange
        User user = new User("English", 85);

        // Act
        int score = user.getScore();

        // Assert
        assertEquals(85, score);
    }

    // Add more test cases as needed

}
