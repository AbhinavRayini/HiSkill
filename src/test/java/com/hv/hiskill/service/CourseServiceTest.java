package com.hv.hiskill.service;

import com.hv.hiskill.model.Course;
import com.hv.hiskill.repository.CourseRepository;
import com.hv.hiskill.service.impl.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class CourseServiceTest {
    @Mock
    private CourseRepository courseRepository;

    private CourseServiceImpl courseservice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        courseservice = new CourseServiceImpl(courseRepository);
    }

    @Test
    void testGetAllCourses() {
        // Mock data
        List<Course> courses = Arrays.asList(
                new Course("1", "Course 1", "About Course 1", Arrays.asList("Topic 1", "Topic 2"), "5 hours", "Article 1", "Exercise 1", "Certificate 1", null),
                new Course("2", "Course 2", "About Course 2", Arrays.asList("Topic 3", "Topic 4"), "3 hours", "Article 2", "Exercise 2", "Certificate 2", null)
        );
        when(courseRepository.findAll()).thenReturn(courses);

        // Test the method
        List<Course> result = courseservice.getAllCourses();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Course 1", result.get(0).getSkillname());
        assertEquals("Course 2", result.get(1).getSkillname());
        verify(courseRepository, times(1)).findAll();
    }

    @Test
    void testCreateCourse() {
        // Mock data
        Course course = new Course("1", "New Course", "About New Course", Arrays.asList("New Topic"), "2 hours", "New Article", "New Exercise", "New Certificate", null);

        // Test the method
        when(courseRepository.save(course)).thenReturn(course);
        Course result = courseservice.createCourse(course);

        // Verify the result
        assertEquals("1", result.getId());
        assertEquals("New Course", result.getSkillname());
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testGetCourseById() {
        // Mock data
        Course course = new Course("1", "Course 1", "About Course 1", Arrays.asList("Topic 1", "Topic 2"), "5 hours", "Article 1", "Exercise 1", "Certificate 1", null);

        // Test the method
        when(courseRepository.findById("1")).thenReturn(Optional.of(course));
        Course result = courseservice.getCourseById("1");

        // Verify the result
        assertEquals("1", result.getId());
        assertEquals("Course 1", result.getSkillname());
        verify(courseRepository, times(1)).findById("1");
    }

    @Test
    void testGetCourseById_NotFound() {
        // Test the method when course is not found
        when(courseRepository.findById("1")).thenReturn(Optional.empty());
        Course result = courseservice.getCourseById("1");

        // Verify the result
        assertNull(result);
        verify(courseRepository, times(1)).findById("1");
    }

    @Test
    void testUpdateCourse() {
        // Mock data
        Course course = new Course("1", "Updated Course", "About Updated Course", Arrays.asList("Updated Topic"), "3 hours", "Updated Article", "Updated Exercise", "Updated Certificate", null);

        // Test the method
        when(courseRepository.save(course)).thenReturn(course);
        Course result = courseservice.updateCourse(course);

        // Verify the result
        assertEquals("1", result.getId());
        assertEquals("Updated Course", result.getSkillname());
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testDeleteCourse() {
        // Mock data
        Course course = new Course("1", "Course 1", "About Course 1", Arrays.asList("Topic 1", "Topic 2"), "5 hours", "Article 1", "Exercise 1", "Certificate 1", null);

        // Test the method
        courseservice.deleteCourse(course);

        // Verify the method call
        verify(courseRepository, times(1)).delete(course);
    }
}
