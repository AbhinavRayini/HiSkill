package com.hv.hiskill.controller;

import com.hv.hiskill.model.CustomizeCourse;
import com.hv.hiskill.service.CustomizeCourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class CustomizeCourseControllerTest {

    @Mock
    private CustomizeCourseService customizeCourseService;

    @InjectMocks
    private CustomizeCourseController customizeCourseController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCourses() {
        List<CustomizeCourse> courses = new ArrayList<>();
        courses.add(new CustomizeCourse("1", "John Doe", Arrays.asList("Topic 1", "Topic 2")));
        courses.add(new CustomizeCourse("2", "Jane Smith", Arrays.asList("Topic 3", "Topic 4")));

        when(customizeCourseService.getAllCourses()).thenReturn(courses);

        ResponseEntity<List<CustomizeCourse>> response = customizeCourseController.getAllCourses();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(courses, response.getBody());

        verify(customizeCourseService, times(1)).getAllCourses();
        verifyNoMoreInteractions(customizeCourseService);
    }

    @Test
    public void testGetCourseById_ValidId() {
        CustomizeCourse course = new CustomizeCourse("1", "John Doe", Arrays.asList("Topic 1", "Topic 2"));

        when(customizeCourseService.getCourseById("1")).thenReturn(course);

        ResponseEntity<CustomizeCourse> response = customizeCourseController.getCourseById("1");

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(course, response.getBody());

        verify(customizeCourseService, times(1)).getCourseById("1");
        verifyNoMoreInteractions(customizeCourseService);
    }

    @Test
    public void testGetCourseById_InvalidId() {
        when(customizeCourseService.getCourseById("999")).thenReturn(null);

        ResponseEntity<CustomizeCourse> response = customizeCourseController.getCourseById("999");

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(response.getBody());

        verify(customizeCourseService, times(1)).getCourseById("999");
        verifyNoMoreInteractions(customizeCourseService);
    }

    @Test
    public void testAddCourse() {
        CustomizeCourse course = new CustomizeCourse("1", "John Doe", Arrays.asList("Topic 1", "Topic 2"));

        when(customizeCourseService.addCourse(course)).thenReturn(course);

        ResponseEntity<CustomizeCourse> response = customizeCourseController.addCourse(course);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(course, response.getBody());

        verify(customizeCourseService, times(1)).addCourse(course);
        verifyNoMoreInteractions(customizeCourseService);
    }

    @Test
    public void testUpdateCourse_ValidId() {
        CustomizeCourse course = new CustomizeCourse("1", "John Doe", Arrays.asList("Topic 1", "Topic 2"));
        CustomizeCourse updatedCourse = new CustomizeCourse("1", "John Smith", Arrays.asList("Topic 1", "Topic 3"));

        when(customizeCourseService.updateCourse("1", updatedCourse)).thenReturn(updatedCourse);

        ResponseEntity<CustomizeCourse> response = customizeCourseController.updateCourse("1", updatedCourse);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(updatedCourse, response.getBody());

        verify(customizeCourseService, times(1)).updateCourse("1", updatedCourse);
        verifyNoMoreInteractions(customizeCourseService);
    }

    @Test
    public void testUpdateCourse_InvalidId() {
        CustomizeCourse updatedCourse = new CustomizeCourse("1", "John Smith", Arrays.asList("Topic 1", "Topic 3"));

        when(customizeCourseService.updateCourse("999", updatedCourse)).thenReturn(null);

        ResponseEntity<CustomizeCourse> response = customizeCourseController.updateCourse("999", updatedCourse);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(response.getBody());

        verify(customizeCourseService, times(1)).updateCourse("999", updatedCourse);
        verifyNoMoreInteractions(customizeCourseService);
    }

    @Test
    public void testDeleteCourse_ValidId() {
        when(customizeCourseService.deleteCourse("1")).thenReturn(true);

        ResponseEntity<Void> response = customizeCourseController.deleteCourse("1");

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        Assertions.assertNull(response.getBody());

        verify(customizeCourseService, times(1)).deleteCourse("1");
        verifyNoMoreInteractions(customizeCourseService);
    }

    @Test
    public void testDeleteCourse_InvalidId() {
        when(customizeCourseService.deleteCourse("999")).thenReturn(false);

        ResponseEntity<Void> response = customizeCourseController.deleteCourse("999");

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(response.getBody());

        verify(customizeCourseService, times(1)).deleteCourse("999");
        verifyNoMoreInteractions(customizeCourseService);
    }
}
