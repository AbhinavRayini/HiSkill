package com.hv.hiskill.controller;

import com.hv.hiskill.model.CourseCard;
import com.hv.hiskill.service.CourseCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/coursecards")
public class CourseCardController {
    private final CourseCardService courseCardService;

    @Autowired
    public CourseCardController(CourseCardService courseCardService) {
        this.courseCardService = courseCardService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<CourseCard>> getAllCourseCards() {
        List<CourseCard> courseCards = courseCardService.getAllCourseCards();
        return new ResponseEntity<>(courseCards, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CourseCard> getCourseCardById(@PathVariable String id) {
        CourseCard courseCard = courseCardService.getCourseCardById(id);
        if (courseCard != null) {
            return new ResponseEntity<>(courseCard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<CourseCard> addCourseCard(@RequestBody CourseCard courseCard) {
        CourseCard createdCourseCard = courseCardService.addCourseCard(courseCard);
        return new ResponseEntity<>(createdCourseCard, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<CourseCard> updateCourseCard(@PathVariable String id, @RequestBody CourseCard courseCard) {
        CourseCard updatedCourseCard = courseCardService.updateCourseCard(id, courseCard);
        if (updatedCourseCard != null) {
            return new ResponseEntity<>(updatedCourseCard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteCourseCard(@PathVariable String id) {
        boolean deleted = courseCardService.deleteCourseCard(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
