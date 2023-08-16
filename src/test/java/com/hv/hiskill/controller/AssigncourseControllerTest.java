package com.hv.hiskill.controller;


import com.hv.hiskill.model.Assigncourse;
import com.hv.hiskill.service.AssigncourseService;
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
import static org.mockito.Mockito.*;

public class AssigncourseControllerTest {

    @Mock
    private AssigncourseService assigncourseService;

    @InjectMocks
    private AssigncourseController assigncourseController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCourses() {

        List<Assigncourse> courses = new ArrayList<>();
        courses.add(new Assigncourse("1", "John Doe", "Course 1", "Description 1"));
        courses.add(new Assigncourse("2", "Jane Smith", "Course 2", "Description 2"));

        when(assigncourseService.getAllCourses()).thenReturn(courses);

        ResponseEntity<List<Assigncourse>> response = assigncourseController.getAllCourses();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(courses, response.getBody());

        verify(assigncourseService, times(1)).getAllCourses();
        verifyNoMoreInteractions(assigncourseService);
    }

    @Test
    public void testGetCourseById() {

        Assigncourse course = new Assigncourse("1", "John Doe", "Course 1", "Description 1");

        when(assigncourseService.getCourseById("1")).thenReturn(course);
        when(assigncourseService.getCourseById("2")).thenReturn(null);

        ResponseEntity<Assigncourse> response1 = assigncourseController.getCourseById("1");

        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());
        Assertions.assertEquals(course, response1.getBody());

        ResponseEntity<Assigncourse> response2 = assigncourseController.getCourseById("2");

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response2.getStatusCode());
        Assertions.assertNull(response2.getBody());

        verify(assigncourseService, times(1)).getCourseById("1");
        verify(assigncourseService, times(1)).getCourseById("2");
        verifyNoMoreInteractions(assigncourseService);
    }
    @Test
    public void testAddCourse() {
        Assigncourse courseToAdd = new Assigncourse("1", "John Doe","Course 1","Description 1");
        when(assigncourseService.addCourse(courseToAdd)).thenReturn(courseToAdd);
        ResponseEntity<Assigncourse> response = assigncourseController.addCourse(courseToAdd);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(courseToAdd, response.getBody());
    }
    @Test
    public void testUpdateCourse() {

        Assigncourse existingCourse = new Assigncourse("1", "John Doe","Course 1","Description 1");
        when(assigncourseService.updateCourse("1", existingCourse)).thenReturn(existingCourse);
        when(assigncourseService.updateCourse("nonexistent", existingCourse)).thenReturn(null);

        ResponseEntity<Assigncourse> existingResponse = assigncourseController.updateCourse("1", existingCourse);
        ResponseEntity<Assigncourse> nonExistingResponse = assigncourseController.updateCourse("nonexistent", existingCourse);
        Assertions.assertEquals(HttpStatus.OK, existingResponse.getStatusCode());
        Assertions.assertNotNull(existingResponse.getBody());
        Assertions.assertEquals(existingCourse, existingResponse.getBody());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, nonExistingResponse.getStatusCode());
    }
    @Test
    public void testDeleteCourse() {

        String existingCourseId = "1";
        when(assigncourseService.deleteCourse(existingCourseId)).thenReturn(true);
        when(assigncourseService.deleteCourse("nonexistent")).thenReturn(false);

        ResponseEntity<Void> existingResponse = assigncourseController.deleteCourse(existingCourseId);
        ResponseEntity<Void> nonExistingResponse = assigncourseController.deleteCourse("nonexistent");

        Assertions.assertEquals(HttpStatus.NO_CONTENT, existingResponse.getStatusCode());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, nonExistingResponse.getStatusCode());
    }
}







