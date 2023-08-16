package com.hv.hiskill.service;

import com.hv.hiskill.model.CourseCard;
import java.util.List;

public interface CourseCardService {
    List<CourseCard> getAllCourseCards();
    CourseCard getCourseCardById(String id);
    CourseCard addCourseCard(CourseCard courseCard);
    CourseCard updateCourseCard(String id, CourseCard courseCard);
    boolean deleteCourseCard(String id);
}

