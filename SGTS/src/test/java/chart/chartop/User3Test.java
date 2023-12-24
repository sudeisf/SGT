package chart.chartop;

import chart.chartop.User3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class User3Test {

    @Test
    public void testGetTableView2col1() {
        // Arrange
        User3 user = new User3("Course X", 75.5f);

        // Act
        String course = user.getTableView2col1();

        // Assert
        assertEquals("Course X", course);
    }

    @Test
    public void testGetTableView2col2() {
        // Arrange
        User3 user = new User3("Course Y", 92.0f);

        // Act
        float score = user.getTableView2col2();

        // Assert
        assertEquals(92.0f, score, 0.001f);
    }

    // Add more test cases as needed

}
