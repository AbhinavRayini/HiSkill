package com.hv.hiskill.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoursedayTest {

    @Test
    public void testGettersAndSetters() {
        Courseday courseday = new Courseday();
        courseday.setdLabel("Day 1");
        courseday.setName("Introduction to Programming");
        courseday.setDetails(Arrays.asList("Lesson 1", "Lesson 2"));
        courseday.setMode(Collections.singletonList("Online"));
        courseday.setTime(120);
        courseday.setPrerequisites(Collections.singletonList("Basic computer skills"));
        courseday.setReferences(Arrays.asList("Reference 1", "Reference 2"));

        Assertions.assertEquals("Day 1", courseday.getdLabel());
        Assertions.assertEquals("Introduction to Programming", courseday.getName());
        Assertions.assertEquals(Arrays.asList("Lesson 1", "Lesson 2"), courseday.getDetails());
        Assertions.assertEquals(Collections.singletonList("Online"), courseday.getMode());
        Assertions.assertEquals(120, courseday.getTime());
        Assertions.assertEquals(Collections.singletonList("Basic computer skills"), courseday.getPrerequisites());
        Assertions.assertEquals(Arrays.asList("Reference 1", "Reference 2"), courseday.getReferences());
    }

    @Test
    public void testEmptyCourseday() {
        Courseday courseday = new Courseday();

        Assertions.assertNull(courseday.getdLabel());
        Assertions.assertNull(courseday.getName());
        Assertions.assertNull(courseday.getDetails());
        Assertions.assertNull(courseday.getMode());
        Assertions.assertEquals(0, courseday.getTime());
        Assertions.assertNull(courseday.getPrerequisites());
        Assertions.assertNull(courseday.getReferences());
    }

    @Test
    public void testSetdLabel() {
        Courseday courseday = new Courseday();
        courseday.setdLabel("Day 2");

        Assertions.assertEquals("Day 2", courseday.getdLabel());
    }

    @Test
    public void testSetName() {
        Courseday courseday = new Courseday();
        courseday.setName("Advanced Topics");

        Assertions.assertEquals("Advanced Topics", courseday.getName());
    }

    @Test
    public void testSetDetails() {
        Courseday courseday = new Courseday();
        List<String> details = Arrays.asList("Lesson 1", "Lesson 2");
        courseday.setDetails(details);

        Assertions.assertSame(details, courseday.getDetails());
    }

    @Test
    public void testSetMode() {
        Courseday courseday = new Courseday();
        List<String> mode = Collections.singletonList("Online");
        courseday.setMode(mode);

        Assertions.assertSame(mode, courseday.getMode());
    }

    @Test
    public void testSetTime() {
        Courseday courseday = new Courseday();
        courseday.setTime(120);

        Assertions.assertEquals(120, courseday.getTime());
    }

    @Test
    public void testSetPrerequisites() {
        Courseday courseday = new Courseday();
        List<String> prerequisites = Collections.singletonList("Basic computer skills");
        courseday.setPrerequisites(prerequisites);

        Assertions.assertSame(prerequisites, courseday.getPrerequisites());
    }

    @Test
    public void testSetReferences() {
        Courseday courseday = new Courseday();
        List<String> references = Arrays.asList("Reference 1", "Reference 2");
        courseday.setReferences(references);

        Assertions.assertSame(references, courseday.getReferences());
    }
}
