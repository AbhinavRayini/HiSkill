package com.hv.hiskill.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class CourseCardTest {

    private CourseCard courseCard;

    @BeforeEach
    public void setUp() {
        courseCard = new CourseCard();
        courseCard.setId("1");
        courseCard.setCourseName("Java Course");
        courseCard.setImage("https://example.com/java-course.jpg");
        courseCard.setCourseProgress(50);
    }

    @Test
    public void testGettersAndSetters() {

        Assertions.assertEquals("1", courseCard.getId());
        Assertions.assertEquals("Java Course", courseCard.getCourseName());
        Assertions.assertEquals("https://example.com/java-course.jpg", courseCard.getImage());
        Assertions.assertEquals(50, courseCard.getCourseProgress());

        courseCard.setId("2");
        courseCard.setCourseName("Python Course");
        courseCard.setImage("https://example.com/python-course.jpg");
        courseCard.setCourseProgress(75);

        Assertions.assertEquals("2", courseCard.getId());
        Assertions.assertEquals("Python Course", courseCard.getCourseName());
        Assertions.assertEquals("https://example.com/python-course.jpg", courseCard.getImage());
        Assertions.assertEquals(75, courseCard.getCourseProgress());
    }

    @Test
    public void testWeekCompletionStatus() {

        Map<Integer, Boolean> initialStatus = new HashMap<>();
        Assertions.assertEquals(initialStatus, courseCard.getWeekCompletionStatus());

        courseCard.markWeekAsCompleted(1);

        Map<Integer, Boolean> updatedStatus = new HashMap<>();
        updatedStatus.put(1, true);

        Assertions.assertEquals(updatedStatus, courseCard.getWeekCompletionStatus());

        courseCard.markWeekAsCompleted(2);
        updatedStatus.put(2, true);

        Assertions.assertEquals(updatedStatus, courseCard.getWeekCompletionStatus());
    }
}