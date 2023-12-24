package chart.chartop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class User4Test {

    @Test
    public void testGetTableView3col1() {
        // Arrange
        User4 user = new User4("Course A", 85.5f);

        // Act
        String course = user.getTableView3col1();

        // Assert
        assertEquals("Course A", course);
    }

    @Test
    public void testGetTableView3col2() {
        // Arrange
        User4 user = new User4("Course B", 77.0f);

        // Act
        float score = user.getTableView3col2();

        // Assert
        assertEquals(77.0f, score, 0.001f);
    }

    // Add more test cases as needed

}
