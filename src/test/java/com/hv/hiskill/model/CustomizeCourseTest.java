package com.hv.hiskill.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomizeCourseTest {

    private CustomizeCourse customizeCourse;

    @BeforeEach
    public void setup() {
        customizeCourse = new CustomizeCourse();
    }

    @Test
    public void testGetId() {
        customizeCourse.setId("1");
        Assertions.assertEquals("1", customizeCourse.getId());
    }

    @Test
    public void testGetEmployeeName() {
        customizeCourse.setEmployeeName("John Doe");
        Assertions.assertEquals("John Doe", customizeCourse.getEmployeeName());
    }

    @Test
    public void testGetTopics() {
        List<String> topics = new ArrayList<>(Arrays.asList("Topic 1", "Topic 2", "Topic 3"));
        customizeCourse.setTopics(topics);
        Assertions.assertEquals(topics, customizeCourse.getTopics());
    }

    @Test
    public void testSetId() {
        customizeCourse.setId("1");
        Assertions.assertEquals("1", customizeCourse.getId());
    }

    @Test
    public void testSetEmployeeName() {
        customizeCourse.setEmployeeName("John Doe");
        Assertions.assertEquals("John Doe", customizeCourse.getEmployeeName());
    }

    @Test
    public void testSetTopics() {
        List<String> topics = new ArrayList<>(Arrays.asList("Topic 1", "Topic 2", "Topic 3"));
        customizeCourse.setTopics(topics);
        Assertions.assertEquals(topics, customizeCourse.getTopics());
    }
}