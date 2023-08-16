package com.hv.hiskill.controller;

import com.hv.hiskill.model.CourseCard;
import com.hv.hiskill.service.CourseCardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class CourseCardControllerTest {

    @Mock
    private CourseCardService courseCardService;

    @InjectMocks
    private CourseCardController courseCardController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCourseCards() {
        CourseCard courseCard1 = new CourseCard("1", "Java Course 1", "https://example.com/java-course1.jpg", 50);
        CourseCard courseCard2 = new CourseCard("2", "Java Course 2", "https://example.com/java-course2.jpg", 75);
        List<CourseCard> courseCards = Arrays.asList(courseCard1, courseCard2);

        when(courseCardService.getAllCourseCards()).thenReturn(courseCards);

        ResponseEntity<List<CourseCard>> response = courseCardController.getAllCourseCards();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(courseCards, response.getBody());
        verify(courseCardService, times(1)).getAllCourseCards();
    }

    @Test
    public void testGetCourseCardById_ValidId() {
        String id = "1";
        CourseCard courseCard = new CourseCard(id, "Java Course", "https://example.com/java-course.jpg", 50);

        when(courseCardService.getCourseCardById(id)).thenReturn(courseCard);

        ResponseEntity<CourseCard> response = courseCardController.getCourseCardById(id);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(courseCard, response.getBody());
        verify(courseCardService, times(1)).getCourseCardById(id);
    }

    @Test
    public void testGetCourseCardById_InvalidId() {
        String id = "1";

        when(courseCardService.getCourseCardById(id)).thenReturn(null);

        ResponseEntity<CourseCard> response = courseCardController.getCourseCardById(id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(response.getBody());
        verify(courseCardService, times(1)).getCourseCardById(id);
    }

    @Test
    public void testAddCourseCard() {
        CourseCard courseCard = new CourseCard("1", "Java Course", "https://example.com/java-course.jpg", 50);

        when(courseCardService.addCourseCard(courseCard)).thenReturn(courseCard);

        ResponseEntity<CourseCard> response = courseCardController.addCourseCard(courseCard);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(courseCard, response.getBody());
        verify(courseCardService, times(1)).addCourseCard(courseCard);
    }

    @Test
    public void testUpdateCourseCard_ValidId() {
        String id = "1";
        CourseCard courseCard = new CourseCard(id, "Java Course", "https://example.com/java-course.jpg", 50);

        when(courseCardService.updateCourseCard(id, courseCard)).thenReturn(courseCard);

        ResponseEntity<CourseCard> response = courseCardController.updateCourseCard(id, courseCard);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(courseCard, response.getBody());
        verify(courseCardService, times(1)).updateCourseCard(id, courseCard);
    }

    @Test
    public void testUpdateCourseCard_InvalidId() {
        String id = "1";
        CourseCard courseCard = new CourseCard(id, "Java Course", "https://example.com/java-course.jpg", 50);

        when(courseCardService.updateCourseCard(id, courseCard)).thenReturn(null);

        ResponseEntity<CourseCard> response = courseCardController.updateCourseCard(id, courseCard);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(response.getBody());
        verify(courseCardService, times(1)).updateCourseCard(id, courseCard);
    }

    @Test
    public void testDeleteCourseCard_ValidId() {
        String id = "1";

        when(courseCardService.deleteCourseCard(id)).thenReturn(true);

        ResponseEntity<Void> response = courseCardController.deleteCourseCard(id);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(courseCardService, times(1)).deleteCourseCard(id);
    }

    @Test
    public void testDeleteCourseCard_InvalidId() {
        String id = "1";

        when(courseCardService.deleteCourseCard(id)).thenReturn(false);

        ResponseEntity<Void> response = courseCardController.deleteCourseCard(id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(courseCardService, times(1)).deleteCourseCard(id);
    }

}
