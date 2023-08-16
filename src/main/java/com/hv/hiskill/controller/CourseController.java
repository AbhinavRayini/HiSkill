package com.hv.hiskill.controller;

import com.hv.hiskill.model.Course;
import com.hv.hiskill.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseServiceImpl courseService;

    @Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") String id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping("/put/{id}")
    public ResponseEntity<Course> updateCourseById(@PathVariable String id, @RequestBody Course updatedCourse) {
        Course existingCourse = courseService.getCourseById(id);
        if (existingCourse != null) {
            existingCourse.setSkillname(updatedCourse.getSkillname());
            existingCourse.setPlan(updatedCourse.getPlan());

            Course savedCourse = courseService.updateCourse(existingCourse);
            return new ResponseEntity<>(savedCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable String id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            courseService.deleteCourse(course);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}