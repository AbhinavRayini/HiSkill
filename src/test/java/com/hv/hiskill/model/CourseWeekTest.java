package com.hv.hiskill.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CourseWeekTest {

    @Test
    public void testGettersAndSetters() {
        CourseWeek week = new CourseWeek();
        week.setLabel("Week 1");
        week.setAbout("Introduction to Programming");
        week.setDays(Collections.emptyMap());

        Assertions.assertEquals("Week 1", week.getLabel());
        Assertions.assertEquals("Introduction to Programming", week.getAbout());
        Assertions.assertTrue(week.getDays().isEmpty());
    }

    @Test
    public void testEmptyWeek() {
        CourseWeek week = new CourseWeek();

        Assertions.assertNull(week.getLabel());
        Assertions.assertNull(week.getAbout());
        Assertions.assertNull(week.getDays());
    }

    @Test
    public void testSetLabel() {
        CourseWeek week = new CourseWeek();
        week.setLabel("Week 2");

        Assertions.assertEquals("Week 2", week.getLabel());
    }

    @Test
    public void testSetAbout() {
        CourseWeek week = new CourseWeek();
        week.setAbout("Advanced Topics");

        Assertions.assertEquals("Advanced Topics", week.getAbout());
    }

    @Test
    public void testSetDays() {
        CourseWeek week = new CourseWeek();
        Map<String, Courseday> days = new HashMap<>();
        week.setDays(days);

        Assertions.assertSame(days, week.getDays());
    }

    @Test
    public void testSetNullValues() {
        CourseWeek week = new CourseWeek();
        week.setLabel(null);
        week.setAbout(null);
        week.setDays(null);

        Assertions.assertNull(week.getLabel());
        Assertions.assertNull(week.getAbout());
        Assertions.assertNull(week.getDays());
    }
}
