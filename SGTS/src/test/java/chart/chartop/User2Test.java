package chart.chartop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class User4Test {

    @Test
    void testGetTableView3col1() {
        // Arrange
        String expectedCol1Value = "TestCourse"; // This can be any value you want for testing
        User4 user = new User4(expectedCol1Value, 85); // Assuming 85 as a sample value for tableView3col2

        // Act
        String actualCol1Value = user.getTableView3col1();

        // Assert
        assertEquals(expectedCol1Value, actualCol1Value, "Expected value should match the actual value.");
    }

    @Test
    void testGetTableView3col2() {
        // Arrange
        float expectedCol2Value = 85.0f; // This can be any value you want for testing
        User4 user = new User4("CourseName", expectedCol2Value); // Assuming "CourseName" as a sample value for tableView3col1

        // Act
        float actualCol2Value = user.getTableView3col2();

        // Assert
        assertEquals(expectedCol2Value, actualCol2Value, 0.001, "Expected value should match the actual value with a delta.");
    }
}
