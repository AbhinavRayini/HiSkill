package com.hv.hiskill.service;


import com.hv.hiskill.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course createCourse(Course course);

    Course getCourseById(String id);

    Course updateCourse(Course course);

    void deleteCourse(Course course);
}

