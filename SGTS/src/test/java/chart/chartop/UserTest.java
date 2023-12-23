package chart.chartop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user; // Declare the User object to be tested

    @BeforeEach
    void setUp() {
        // Set up a User object for testing
        user = new User("Example Course", 75);
    }

    @Test
    void getCourse() {
        // Check if the course name fetched from the User object matches the expected value
        assertEquals("Example Course", user.getCourse(), "Course name should match");
    }

    @Test
    void getScore() {
        // Verify if the score obtained from the User object is as expected
        assertEquals(75, user.getScore(), "Score should be 75");
    }
}
