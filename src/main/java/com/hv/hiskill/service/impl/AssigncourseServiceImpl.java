package com.hv.hiskill.service.impl;

import com.hv.hiskill.model.Assigncourse;
import com.hv.hiskill.repository.AssigncourseRepository;
import com.hv.hiskill.service.AssigncourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AssigncourseServiceImpl implements AssigncourseService {
    private final AssigncourseRepository assigncourseRepository;

    @Autowired
    public AssigncourseServiceImpl(AssigncourseRepository assigncourseRepository) {
        this.assigncourseRepository = assigncourseRepository;
    }

    @Override
    public List<Assigncourse> getAllCourses() {
        return assigncourseRepository.findAll();
    }

    @Override
    public Assigncourse getCourseById(String id) {
        Optional<Assigncourse> courseOptional = assigncourseRepository.findById(id);
        return courseOptional.orElse(null);
    }

    @Override
    public Assigncourse addCourse(Assigncourse course) {
        return assigncourseRepository.save(course);
    }

    @Override
    public Assigncourse updateCourse(String id, Assigncourse updatedCourse) {
        Optional<Assigncourse> courseOptional = assigncourseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Assigncourse course = courseOptional.get();
            course.setEmployeeName(updatedCourse.getEmployeeName());
            course.setCourseName(updatedCourse.getCourseName());
            course.setDescription(updatedCourse.getDescription());
            return assigncourseRepository.save(course);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteCourse(String id) {
        Optional<Assigncourse> courseOptional = assigncourseRepository.findById(id);
        if (courseOptional.isPresent()) {
            assigncourseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}