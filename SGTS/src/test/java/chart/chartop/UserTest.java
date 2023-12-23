package chart.chartop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        // Create a User object with a score of 90 for setup
        user = new User("Operating system", 90);
    }

    @Test
    void calculateGrade() {
        // Test if the grade is A for a score of 90
        assertEquals(User.Grade.A, user.calculateGrade());

    }

    @Test
    void getCourse () {
        // Test if the course name is "Operating system"
        assertEquals("Operating system", user.getCourse());
    }

    @Test
    void getScore () {
        // Test if the score is 90
        assertEquals(90, user.getScore());
    }

    @Test
    void getGrade () {
        // Test if the grade is A
        assertEquals(User.Grade.A, user.getGrade());
    }

    @Test
    void getGradeValue () {
        // Test if the grade value is 4 for A
        assertEquals(4, user.getGradeValue());

    }
}
