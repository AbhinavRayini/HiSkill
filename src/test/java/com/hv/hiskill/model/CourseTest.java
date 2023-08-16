package com.hv.hiskill.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CourseTest {

    @Test
    public void testGettersAndSetters() {
        Course course = new Course();
        course.setId("123");
        course.setSkillname("Java Programming");
        course.setAbout("Learn Java programming");
        course.setLearning(Arrays.asList("Java basics", "Object-oriented programming"));
        course.setTotalTime("10 hours");
        course.setArticles("Java articles");
        course.setExercises("Java exercises");
        course.setCertificate("Certificate of completion");

        Map<String, CourseWeek> plan = new HashMap<>();
        CourseWeek week1 = new CourseWeek();
        week1.setLabel("Week 1");
        week1.setAbout("Introduction to Java");
        week1.setDays(Collections.emptyMap());
        plan.put("week1", week1);

        course.setPlan(plan);

        Assertions.assertEquals("123", course.getId());
        Assertions.assertEquals("Java Programming", course.getSkillname());
        Assertions.assertEquals("Learn Java programming", course.getAbout());
        Assertions.assertEquals(Arrays.asList("Java basics", "Object-oriented programming"), course.getLearning());
        Assertions.assertEquals("10 hours", course.getTotalTime());
        Assertions.assertEquals("Java articles", course.getArticles());
        Assertions.assertEquals("Java exercises", course.getExercises());
        Assertions.assertEquals("Certificate of completion", course.getCertificate());

        Assertions.assertEquals(1, course.getPlan().size());
        CourseWeek retrievedWeek1 = course.getPlan().get("week1");
        Assertions.assertNotNull(retrievedWeek1);
        Assertions.assertEquals("Week 1", retrievedWeek1.getLabel());
        Assertions.assertEquals("Introduction to Java", retrievedWeek1.getAbout());
        Assertions.assertNotNull(retrievedWeek1.getDays());
        Assertions.assertTrue(retrievedWeek1.getDays().isEmpty());
    }

    @Test
    public void testEmptyCourse() {
        Course course = new Course();

        Assertions.assertNull(course.getId());
        Assertions.assertNull(course.getSkillname());
        Assertions.assertNull(course.getAbout());
        Assertions.assertNull(course.getLearning());
        Assertions.assertNull(course.getTotalTime());
        Assertions.assertNull(course.getArticles());
        Assertions.assertNull(course.getExercises());
        Assertions.assertNull(course.getCertificate());
        Assertions.assertNull(course.getPlan());
    }

    @Test
    public void testSetId() {
        Course course = new Course();
        course.setId("456");

        Assertions.assertEquals("456", course.getId());
    }

    @Test
    public void testSetSkillname() {
        Course course = new Course();
        course.setSkillname("Python Programming");

        Assertions.assertEquals("Python Programming", course.getSkillname());
    }

    @Test
    public void testSetLearning() {
        Course course = new Course();
        course.setLearning(Arrays.asList("Python basics", "Data analysis"));

        Assertions.assertEquals(Arrays.asList("Python basics", "Data analysis"), course.getLearning());
    }

    @Test
    public void testSetPlan() {
        Course course = new Course();
        Map<String, CourseWeek> plan = new HashMap<>();
        CourseWeek week1 = new CourseWeek();
        week1.setLabel("Week 1");
        week1.setAbout("Introduction to Python");
        week1.setDays(Collections.emptyMap());
        plan.put("week1", week1);
        course.setPlan(plan);

        Assertions.assertEquals(1, course.getPlan().size());
        CourseWeek retrievedWeek1 = course.getPlan().get("week1");
        Assertions.assertNotNull(retrievedWeek1);
        Assertions.assertEquals("Week 1", retrievedWeek1.getLabel());
        Assertions.assertEquals("Introduction to Python", retrievedWeek1.getAbout());
        Assertions.assertNotNull(retrievedWeek1.getDays());
        Assertions.assertTrue(retrievedWeek1.getDays().isEmpty());
    }

    @Test
    public void testSetNullValues() {
        Course course = new Course();
        course.setId(null);
        course.setSkillname(null);
        course.setAbout(null);
        course.setLearning(null);
        course.setTotalTime(null);
        course.setArticles(null);
        course.setExercises(null);
        course.setCertificate(null);
        course.setPlan(null);

        Assertions.assertNull(course.getId());
        Assertions.assertNull(course.getSkillname());
        Assertions.assertNull(course.getAbout());
        Assertions.assertNull(course.getLearning());
        Assertions.assertNull(course.getTotalTime());
        Assertions.assertNull(course.getArticles());
        Assertions.assertNull(course.getExercises());
        Assertions.assertNull(course.getCertificate());
        Assertions.assertNull(course.getPlan());
    }
}
