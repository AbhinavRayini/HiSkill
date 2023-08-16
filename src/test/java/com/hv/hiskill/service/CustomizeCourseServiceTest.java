package com.hv.hiskill.service;

import com.hv.hiskill.model.CustomizeCourse;
import com.hv.hiskill.repository.CustomizeCourseRepository;
import com.hv.hiskill.service.impl.CustomizeCourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomizeCourseServiceTest {
    @Mock
    private CustomizeCourseRepository customizeCourseRepository;

    private CustomizeCourseService customizeCourseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customizeCourseService = new CustomizeCourseServiceImpl(customizeCourseRepository);
    }

    @Test
    void testGetAllCourses() {
        // Mocking the repository's findAll method
        List<CustomizeCourse> mockCourses = new ArrayList<>();
        mockCourses.add(new CustomizeCourse("1", "Course 1",Arrays.asList("Topic 1", "Topic 2")));
        mockCourses.add(new CustomizeCourse("2", "Course 2",Arrays.asList("Topic 1", "Topic 2")));
        when(customizeCourseRepository.findAll()).thenReturn(mockCourses);

        List<CustomizeCourse> result = customizeCourseService.getAllCourses();

        assertEquals(2, result.size());
        assertEquals("Course 1", result.get(0).getEmployeeName());
        assertEquals("Course 2", result.get(1).getEmployeeName());
        verify(customizeCourseRepository, times(1)).findAll();
    }

    @Test
    void testGetCourseById() {
        // Mocking the repository's findById method
        String courseId = "1";
        CustomizeCourse mockCourse = new CustomizeCourse(courseId, "Course 1",Arrays.asList("Topic 1", "Topic 2"));
        when(customizeCourseRepository.findById(courseId)).thenReturn(Optional.of(mockCourse));

        CustomizeCourse result = customizeCourseService.getCourseById(courseId);

        assertNotNull(result);
        assertEquals(courseId, result.getId());
        assertEquals("Course 1", result.getEmployeeName());
        verify(customizeCourseRepository, times(1)).findById(courseId);
    }

    @Test
    void testGetCourseById_NotFound() {
        // Mocking the repository's findById method to return empty optional
        String courseId = "1";
        when(customizeCourseRepository.findById(courseId)).thenReturn(Optional.empty());

        CustomizeCourse result = customizeCourseService.getCourseById(courseId);

        assertNull(result);
        verify(customizeCourseRepository, times(1)).findById(courseId);
    }

    @Test
    void testAddCourse() {

        CustomizeCourse course = new CustomizeCourse("1", "Course 1",Arrays.asList("Topic 1", "Topic 2"));
        when(customizeCourseRepository.save(course)).thenReturn(course);

        CustomizeCourse result = customizeCourseService.addCourse(course);

        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("Course 1", result.getEmployeeName());
        verify(customizeCourseRepository, times(1)).save(course);
    }

    @Test
    void testUpdateCourse() {

        String courseId = "1";
        CustomizeCourse existingCourse = new CustomizeCourse(courseId, "Course 1",Arrays.asList("Topic 1", "Topic 2"));
        when(customizeCourseRepository.findById(courseId)).thenReturn(Optional.of(existingCourse));
        when(customizeCourseRepository.save(existingCourse)).thenReturn(existingCourse);

        CustomizeCourse updatedCourse = new CustomizeCourse(courseId, "Updated Course 1",Arrays.asList("Topic 1", "Topic 2"));
        CustomizeCourse result = customizeCourseService.updateCourse(courseId, updatedCourse);

        assertNotNull(result);
        assertEquals(courseId, result.getId());
        assertEquals("Updated Course 1", result.getEmployeeName());
        verify(customizeCourseRepository, times(1)).findById(courseId);
        verify(customizeCourseRepository, times(1)).save(existingCourse);
    }

    @Test
    void testUpdateCourse_NotFound() {
        String courseId = "1";
        when(customizeCourseRepository.findById(courseId)).thenReturn(Optional.empty());

        CustomizeCourse updatedCourse = new CustomizeCourse(courseId, "Updated Course 1",Arrays.asList("Topic 1", "Topic 2"));
        CustomizeCourse result = customizeCourseService.updateCourse(courseId, updatedCourse);

        assertNull(result);
        verify(customizeCourseRepository, times(1)).findById(courseId);
        verify(customizeCourseRepository, never()).save(any());
    }

    @Test
    void testDeleteCourse() {
        String courseId = "1";
        when(customizeCourseRepository.existsById(courseId)).thenReturn(true);
        boolean result = customizeCourseService.deleteCourse(courseId);
        assertTrue(result);
        verify(customizeCourseRepository, times(1)).existsById(courseId);
        verify(customizeCourseRepository, times(1)).deleteById(courseId);
    }

    @Test
    void testDeleteCourse_NotFound() {
        String courseId = "1";
        when(customizeCourseRepository.existsById(courseId)).thenReturn(false);

        boolean result = customizeCourseService.deleteCourse(courseId);

        assertFalse(result);
        verify(customizeCourseRepository, times(1)).existsById(courseId);
        verify(customizeCourseRepository, never()).deleteById(any());
    }
}
