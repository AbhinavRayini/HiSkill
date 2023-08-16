package com.hv.hiskill.service;

import com.hv.hiskill.model.CourseCard;
import com.hv.hiskill.repository.CourseCardRepository;
import com.hv.hiskill.service.impl.CourseCardServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

public class CourseCardServiceTest {

    @Mock
    private CourseCardRepository courseCardRepository;

    @InjectMocks
    private CourseCardServiceImpl courseCardService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCourseCards() {
        List<CourseCard> courseCards = new ArrayList<>();
        courseCards.add(new CourseCard("1", "Java Course 1", "https://example.com/java-course1.jpg", 50));
        courseCards.add(new CourseCard("2", "Java Course 2", "https://example.com/java-course2.jpg", 75));

        when(courseCardRepository.findAll()).thenReturn(courseCards);

        List<CourseCard> result = courseCardService.getAllCourseCards();

        Assertions.assertEquals(courseCards, result);
        verify(courseCardRepository, times(1)).findAll();
    }

    @Test
    public void testGetCourseCardById_ExistingId() {
        String id = "1";
        CourseCard courseCard = new CourseCard(id, "Java Course", "https://example.com/java-course.jpg", 50);

        when(courseCardRepository.findById(id)).thenReturn(Optional.of(courseCard));

        CourseCard result = courseCardService.getCourseCardById(id);

        Assertions.assertEquals(courseCard, result);
        verify(courseCardRepository, times(1)).findById(id);
    }

    @Test
    public void testGetCourseCardById_NonExistingId() {
        String id = "1";

        when(courseCardRepository.findById(id)).thenReturn(Optional.empty());

        CourseCard result = courseCardService.getCourseCardById(id);

        Assertions.assertNull(result);
        verify(courseCardRepository, times(1)).findById(id);
    }

    @Test
    public void testAddCourseCard() {
        CourseCard courseCard = new CourseCard("1", "Java Course", "https://example.com/java-course.jpg", 50);

        when(courseCardRepository.save(courseCard)).thenReturn(courseCard);

        CourseCard result = courseCardService.addCourseCard(courseCard);

        Assertions.assertEquals(courseCard, result);
        verify(courseCardRepository, times(1)).save(courseCard);
    }

    @Test
    public void testUpdateCourseCard_ExistingId() {
        String id = "1";
        CourseCard existingCourseCard = new CourseCard(id, "Java Course", "https://example.com/java-course.jpg", 50);
        CourseCard updatedCourseCard = new CourseCard(id, "Updated Java Course", "https://example.com/updated-java-course.jpg", 75);

        when(courseCardRepository.findById(id)).thenReturn(Optional.of(existingCourseCard));
        when(courseCardRepository.save(existingCourseCard)).thenReturn(updatedCourseCard);

        CourseCard result = courseCardService.updateCourseCard(id, updatedCourseCard);

        Assertions.assertEquals(updatedCourseCard, result);
        verify(courseCardRepository, times(1)).findById(id);
        verify(courseCardRepository, times(1)).save(existingCourseCard);
    }

    @Test
    public void testUpdateCourseCard_NonExistingId() {
        String id = "1";
        CourseCard courseCard = new CourseCard(id, "Java Course", "https://example.com/java-course.jpg", 50);

        when(courseCardRepository.findById(id)).thenReturn(Optional.empty());

        CourseCard result = courseCardService.updateCourseCard(id, courseCard);

        Assertions.assertNull(result);
        verify(courseCardRepository, times(1)).findById(id);
        verify(courseCardRepository, times(0)).save(any(CourseCard.class));
    }

    @Test
    public void testDeleteCourseCard_ExistingId() {
        String id = "1";
        CourseCard existingCourseCard = new CourseCard(id, "Java Course", "https://example.com/java-course.jpg", 50);

        when(courseCardRepository.findById(id)).thenReturn(Optional.of(existingCourseCard));

        boolean result = courseCardService.deleteCourseCard(id);

        Assertions.assertTrue(result);
        verify(courseCardRepository, times(1)).findById(id);
        verify(courseCardRepository, times(1)).delete(existingCourseCard);
    }

    @Test
    public void testDeleteCourseCard_NonExistingId() {
        String id = "1";

        when(courseCardRepository.findById(id)).thenReturn(Optional.empty());

        boolean result = courseCardService.deleteCourseCard(id);

        Assertions.assertFalse(result);
        verify(courseCardRepository, times(1)).findById(id);
        verify(courseCardRepository, times(0)).delete(any(CourseCard.class));
    }
}