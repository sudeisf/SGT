package chart.chartop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ChartDisplayAppTest {

    @Test
    public void testUserGetters() {
        // Arrange
        String course = "Math";
        int score = 90;

        // Act
        User user = new User(course, score);

        // Assert
        assertEquals(course, user.getCourse());
        assertEquals(score, user.getScore());
    }

    @Test
    public void testUserWithMockito() {
        // Arrange
        String course = "English";
        int score = 85;

        // Create a mock User object
        User mockedUser = mock(User.class);
        when(mockedUser.getCourse()).thenReturn(course);
        when(mockedUser.getScore()).thenReturn(score);

        // Act
        String actualCourse = mockedUser.getCourse();
        int actualScore = mockedUser.getScore();

        // Assert
        assertEquals(course, actualCourse);
        assertEquals(score, actualScore);

        // Optionally, verify that certain methods were called
        verify(mockedUser, times(1)).getCourse();
        verify(mockedUser, times(1)).getScore();
    }
}
