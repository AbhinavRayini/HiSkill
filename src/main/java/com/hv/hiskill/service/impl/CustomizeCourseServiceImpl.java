package com.hv.hiskill.service.impl;

import com.hv.hiskill.model.CustomizeCourse;
import com.hv.hiskill.repository.CustomizeCourseRepository;
import com.hv.hiskill.service.CustomizeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomizeCourseServiceImpl implements CustomizeCourseService {
    private final CustomizeCourseRepository customizeCourseRepository;

    @Autowired
    public CustomizeCourseServiceImpl(CustomizeCourseRepository customizeCourseRepository) {
        this.customizeCourseRepository = customizeCourseRepository;
    }

    @Override
    public List<CustomizeCourse> getAllCourses() {
        return customizeCourseRepository.findAll();
    }

    @Override
    public CustomizeCourse getCourseById(String id) {
        return customizeCourseRepository.findById(id).orElse(null);
    }

    @Override
    public CustomizeCourse addCourse(CustomizeCourse course) {
        return customizeCourseRepository.save(course);
    }

    @Override
    public CustomizeCourse updateCourse(String id, CustomizeCourse course) {
        CustomizeCourse existingCourse = customizeCourseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setEmployeeName(course.getEmployeeName());
            existingCourse.setTopics(course.getTopics());

            return customizeCourseRepository.save(existingCourse);
        }
        return null;
    }

    @Override
    public boolean deleteCourse(String id) {
        if (customizeCourseRepository.existsById(id)) {
            customizeCourseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}