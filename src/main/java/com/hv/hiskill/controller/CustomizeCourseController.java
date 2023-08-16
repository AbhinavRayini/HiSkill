package com.hv.hiskill.controller;

import com.hv.hiskill.model.CustomizeCourse;
import com.hv.hiskill.service.CustomizeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customizecourses")
public class CustomizeCourseController {
    private final CustomizeCourseService customizeCourseService;

    @Autowired
    public CustomizeCourseController(CustomizeCourseService customizeCourseService) {
        this.customizeCourseService = customizeCourseService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<CustomizeCourse>> getAllCourses() {
        List<CustomizeCourse> courses = customizeCourseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CustomizeCourse> getCourseById(@PathVariable String id) {
        CustomizeCourse course = customizeCourseService.getCourseById(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<CustomizeCourse> addCourse(@RequestBody CustomizeCourse course) {
        CustomizeCourse createdCourse = customizeCourseService.addCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<CustomizeCourse> updateCourse(@PathVariable String id, @RequestBody CustomizeCourse course) {
        CustomizeCourse updatedCourse = customizeCourseService.updateCourse(id, course);
        if (updatedCourse != null) {
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        boolean deleted = customizeCourseService.deleteCourse(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
