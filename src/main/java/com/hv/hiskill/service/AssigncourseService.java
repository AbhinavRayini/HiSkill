package com.hv.hiskill.service;

import com.hv.hiskill.model.Assigncourse;
import java.util.List;
public interface AssigncourseService {
    List<Assigncourse> getAllCourses();

    Assigncourse getCourseById(String id);

    Assigncourse addCourse(Assigncourse course);

    Assigncourse updateCourse(String id, Assigncourse updatedCourse);

    boolean deleteCourse(String id);
}