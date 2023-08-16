package com.hv.hiskill.service.impl;

import com.hv.hiskill.model.CourseCard;
import com.hv.hiskill.repository.CourseCardRepository;
import com.hv.hiskill.service.CourseCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseCardServiceImpl implements CourseCardService {
    private final CourseCardRepository courseCardRepository;

    @Autowired
    public CourseCardServiceImpl(CourseCardRepository courseCardRepository) {
        this.courseCardRepository = courseCardRepository;
    }

    @Override
    public List<CourseCard> getAllCourseCards() {
        return courseCardRepository.findAll();
    }

    @Override
    public CourseCard getCourseCardById(String id) {
        return courseCardRepository.findById(id).orElse(null);
    }

    @Override
    public CourseCard addCourseCard(CourseCard courseCard) {
        return courseCardRepository.save(courseCard);
    }

    @Override
    public CourseCard updateCourseCard(String id, CourseCard courseCard) {
        CourseCard existingCourseCard = courseCardRepository.findById(id).orElse(null);
        if (existingCourseCard != null) {
            existingCourseCard.setCourseProgress(courseCard.getCourseProgress());
            existingCourseCard.setWeekCompletionStatus(courseCard.getWeekCompletionStatus());
            if (courseCard.getImage() != null) {
                existingCourseCard.setImage(courseCard.getImage());
            }
            if (courseCard.getCourseName() != null) {
                existingCourseCard.setCourseName(courseCard.getCourseName());
            }
            return courseCardRepository.save(existingCourseCard);
        }
        return null;
    }

    @Override
    public boolean deleteCourseCard(String id) {
        CourseCard existingCourseCard = courseCardRepository.findById(id).orElse(null);
        if (existingCourseCard != null) {
            courseCardRepository.delete(existingCourseCard);
            return true;
        }
        return false;
    }
}
