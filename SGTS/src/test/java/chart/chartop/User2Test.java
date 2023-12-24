package chart.chartop;

import chart.chartop.User2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class User2Test {

    @Test
    public void testGetTableView1col1() {
        // Arrange
        User2 user = new User2("Course A", 95.5f);

        // Act
        String course = user.getTableView1col1();

        // Assert
        assertEquals("Course A", course);
    }

    @Test
    public void testGetTableView1col2() {
        // Arrange
        User2 user = new User2("Course B", 88.0f);

        // Act
        float score = user.getTableView1col2();

        // Assert
        assertEquals(88.0f, score, 0.001f);
    }

    // Add more test cases as needed

}
