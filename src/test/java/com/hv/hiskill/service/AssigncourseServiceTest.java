package com.hv.hiskill.service;

import com.hv.hiskill.model.Assigncourse;
import com.hv.hiskill.repository.AssigncourseRepository;
import com.hv.hiskill.service.impl.AssigncourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AssigncourseServiceTest {

    @Mock
    private AssigncourseRepository assigncourseRepository;

    @InjectMocks
    private AssigncourseServiceImpl assigncourseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCourses() {

        List<Assigncourse> mockCourses = new ArrayList<>();
        mockCourses.add(new Assigncourse("1", "Manisha", "Java","Description 1"));
        mockCourses.add(new Assigncourse("2", "Jane", "Python","Description 2"));
        when(assigncourseRepository.findAll()).thenReturn(mockCourses);

        List<Assigncourse> courses = assigncourseService.getAllCourses();

        assertEquals(2, courses.size());
        assertEquals("Java", courses.get(0).getCourseName());
        assertEquals("Python", courses.get(1).getCourseName());
        verify(assigncourseRepository, times(1)).findAll();
    }

    @Test
    void testGetCourseById() {
        String courseId = "1";
        Assigncourse mockCourse = new Assigncourse(courseId, "Manish", "Java","Description 1");
        when(assigncourseRepository.findById(courseId)).thenReturn(Optional.of(mockCourse));

        Assigncourse course = assigncourseService.getCourseById(courseId);

        assertNotNull(course);
        assertEquals(courseId, course.getId());
        assertEquals("Java", course.getCourseName());
        verify(assigncourseRepository, times(1)).findById(courseId);
    }

    @Test
    void testGetCourseById_NotFound() {

        String courseId = "1";
        when(assigncourseRepository.findById(courseId)).thenReturn(Optional.empty());

        Assigncourse course = assigncourseService.getCourseById(courseId);

        assertNull(course);
        verify(assigncourseRepository, times(1)).findById(courseId);
    }

    @Test
    void testAddCourse() {

        Assigncourse newCourse = new Assigncourse("1", "Manisha", "Java", "Description 1");

        when(assigncourseRepository.save(newCourse)).thenReturn(newCourse);

        Assigncourse createdCourse = assigncourseService.addCourse(newCourse);

        assertNotNull(createdCourse);
        assertEquals(newCourse, createdCourse);
        verify(assigncourseRepository, times(1)).save(newCourse);
    }

    @Test
    void testUpdateCourse() {

        Assigncourse existingCourse = new Assigncourse("1", "Manisha", "Java","Description 1");
        Assigncourse updatedCourse = new Assigncourse("1", "Updated Course", "Updated CourseName","Updated Description");

        when(assigncourseRepository.findById(existingCourse.getId())).thenReturn(Optional.of(existingCourse));

        when(assigncourseRepository.save(existingCourse)).thenReturn(updatedCourse);

        Assigncourse result = assigncourseService.updateCourse(existingCourse.getId(), updatedCourse);

        assertNotNull(result);
        assertEquals(updatedCourse, result);
        assertEquals("Updated CourseName", result.getCourseName());
        assertEquals("Updated Description", result.getDescription());
        verify(assigncourseRepository, times(1)).findById(existingCourse.getId());
        verify(assigncourseRepository, times(1)).save(existingCourse);
    }

    @Test
    void testUpdateCourse_NotFound() {

        Assigncourse updatedCourse = new Assigncourse("1", "Updated Course","Updated CourseName", "Updated Description");

        when(assigncourseRepository.findById(updatedCourse.getId())).thenReturn(Optional.empty());

        Assigncourse result = assigncourseService.updateCourse(updatedCourse.getId(), updatedCourse);

        assertNull(result);
        verify(assigncourseRepository, times(1)).findById(updatedCourse.getId());
        verify(assigncourseRepository, never()).save(any(Assigncourse.class));
    }

    @Test
    void testDeleteCourse() {

        String courseId = "1";
        when(assigncourseRepository.findById(courseId)).thenReturn(Optional.of(new Assigncourse()));
        boolean deleted = assigncourseService.deleteCourse(courseId);
        assertTrue(deleted);
        verify(assigncourseRepository, times(1)).findById(courseId);
        verify(assigncourseRepository, times(1)).deleteById(courseId);
    }

    @Test
    void testDeleteCourse_NotFound() {
        String courseId = "1";
        when(assigncourseRepository.findById(courseId)).thenReturn(Optional.empty());
        boolean deleted = assigncourseService.deleteCourse(courseId);
        assertFalse(deleted);
        verify(assigncourseRepository, times(1)).findById(courseId);
        verify(assigncourseRepository, never()).deleteById(anyString());
    }
}