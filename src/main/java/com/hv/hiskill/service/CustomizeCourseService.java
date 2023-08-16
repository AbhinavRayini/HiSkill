package com.hv.hiskill.service;

import com.hv.hiskill.model.CustomizeCourse;
import java.util.List;

public interface CustomizeCourseService {
    List<CustomizeCourse> getAllCourses();
    CustomizeCourse getCourseById(String id);
    CustomizeCourse addCourse(CustomizeCourse course);
    CustomizeCourse updateCourse(String id, CustomizeCourse course);
    boolean deleteCourse(String id);
}