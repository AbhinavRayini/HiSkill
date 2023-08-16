package com.hv.hiskill.controller;

import com.hv.hiskill.model.Assigncourse;
import com.hv.hiskill.service.AssigncourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Assigncourse")
public class AssigncourseController {
    private final AssigncourseService assigncourseService;
    @Autowired
    public AssigncourseController(AssigncourseService assigncourseService) {
        this.assigncourseService = assigncourseService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Assigncourse>> getAllCourses() {
        List<Assigncourse> courses = assigncourseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Assigncourse> getCourseById(@PathVariable String id) {
        Assigncourse course = assigncourseService.getCourseById(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Assigncourse> addCourse(@RequestBody Assigncourse course) {
        Assigncourse createdCourse = assigncourseService.addCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Assigncourse> updateCourse(@PathVariable String id, @RequestBody Assigncourse course) {
        Assigncourse updatedCourse = assigncourseService.updateCourse(id, course);
        if (updatedCourse != null) {
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        boolean deleted = assigncourseService.deleteCourse(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}