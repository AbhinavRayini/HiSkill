package com.hv.hiskill.controller;

import com.hv.hiskill.model.Course;
import com.hv.hiskill.service.impl.CourseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class CourseControllerTest {

    @Mock
    private CourseServiceImpl courseService;

    @InjectMocks
    private CourseController courseController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("1", "Java", "About Java", null, "2 hours", null, null, null, null));
        courses.add(new Course("2", "Python", "About Python", null, "3 hours", null, null, null, null));

        when(courseService.getAllCourses()).thenReturn(courses);

        ResponseEntity<List<Course>> response = courseController.getAllCourses();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(courses, response.getBody());
        verify(courseService, times(1)).getAllCourses();
    }

    @Test
    public void testCreateCourse() {
        Course course = new Course("1", "Java", "About Java", null, "2 hours", null, null, null, null);

        when(courseService.createCourse(any(Course.class))).thenReturn(course);

        ResponseEntity<Course> response = courseController.createCourse(course);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(course, response.getBody());
        verify(courseService, times(1)).createCourse(any(Course.class));
    }

    @Test
    public void testGetCourseById() {
        Course course = new Course("1", "Java", "About Java", null, "2 hours", null, null, null, null);

        when(courseService.getCourseById("1")).thenReturn(course);
        when(courseService.getCourseById("2")).thenReturn(null);

        ResponseEntity<Course> response1 = courseController.getCourseById("1");
        ResponseEntity<Course> response2 = courseController.getCourseById("2");

        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());
        Assertions.assertEquals(course, response1.getBody());

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response2.getStatusCode());
        verify(courseService, times(2)).getCourseById(anyString());
    }

    @Test
    public void testUpdateCourseById() {
        Course existingCourse = new Course("1", "Java", "About Java", null, "2 hours", null, null, null, null);
        Course updatedCourse = new Course("1", "Python", "About Python", null, "3 hours", null, null, null, null);

        when(courseService.getCourseById("1")).thenReturn(existingCourse);
        when(courseService.updateCourse(any(Course.class))).thenReturn(updatedCourse);

        ResponseEntity<Course> response = courseController.updateCourseById("1", updatedCourse);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(updatedCourse, response.getBody());
        verify(courseService, times(1)).getCourseById("1");
        verify(courseService, times(1)).updateCourse(any(Course.class));
    }

    @Test
    public void testUpdateCourseByIdNotFound() {
        Course updatedCourse = new Course("1", "Python", "About Python", null, "3 hours", null, null, null, null);

        when(courseService.getCourseById("1")).thenReturn(null);

        ResponseEntity<Course> response = courseController.updateCourseById("1", updatedCourse);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(courseService, times(1)).getCourseById("1");
        verify(courseService, times(0)).updateCourse(any(Course.class));
    }

    @Test
    public void testDeleteCourseById() {
        Course course = new Course("1", "Java", "About Java", null, "2 hours", null, null, null, null);

        when(courseService.getCourseById("1")).thenReturn(course);

        ResponseEntity<Void> response = courseController.deleteCourseById("1");

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(courseService, times(1)).getCourseById("1");
        verify(courseService, times(1)).deleteCourse(any(Course.class));
    }

    @Test
    public void testDeleteCourseByIdNotFound() {
        when(courseService.getCourseById("1")).thenReturn(null);

        ResponseEntity<Void> response = courseController.deleteCourseById("1");

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(courseService, times(1)).getCourseById("1");
        verify(courseService, times(0)).deleteCourse(any(Course.class));
    }
}

