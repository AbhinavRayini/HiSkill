package com.hv.hiskill.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssigncourseTest {

    @Test
    public void testGettersAndSetters() {
        Assigncourse assigncourse = new Assigncourse();

        assigncourse.setId("1");
        assigncourse.setEmployeeName("John Doe");
        assigncourse.setCourseName("Java Programming");
        assigncourse.setDescription("Introduction to Java programming language");

        Assertions.assertEquals("1", assigncourse.getId());
        Assertions.assertEquals("John Doe", assigncourse.getEmployeeName());
        Assertions.assertEquals("Java Programming", assigncourse.getCourseName());
        Assertions.assertEquals("Introduction to Java programming language", assigncourse.getDescription());
    }

    @Test
    public void testConstructorWithParameters() {
        Assigncourse assigncourse = new Assigncourse("1", "John Doe", "Java Programming", "Introduction to Java programming language");

        Assertions.assertEquals("1", assigncourse.getId());
        Assertions.assertEquals("John Doe", assigncourse.getEmployeeName());
        Assertions.assertEquals("Java Programming", assigncourse.getCourseName());
        Assertions.assertEquals("Introduction to Java programming language", assigncourse.getDescription());
    }

}