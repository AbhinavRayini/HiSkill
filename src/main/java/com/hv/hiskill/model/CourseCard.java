package com.hv.hiskill.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "coursecard")
public class CourseCard {
    @Id
    private String id;
    private String courseName;
    private String image;
    private int courseProgress;
    private Map<Integer, Boolean> weekCompletionStatus;

    public CourseCard() {
        weekCompletionStatus = new HashMap<>();
    }

    public CourseCard(String id, String courseName, String image, int courseProgress) {
        this.id = id;
        this.courseName = courseName;
        this.image = image;
        this.courseProgress = courseProgress;
        weekCompletionStatus = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCourseProgress() {
        return courseProgress;
    }

    public void setCourseProgress(int courseProgress) {
        this.courseProgress = courseProgress;
    }

    public Map<Integer, Boolean> getWeekCompletionStatus() {
        return weekCompletionStatus;
    }

    public void setWeekCompletionStatus(Map<Integer, Boolean> weekCompletionStatus) {
        this.weekCompletionStatus = weekCompletionStatus;
    }

    public void markWeekAsCompleted(int weekNumber) {
        weekCompletionStatus.put(weekNumber, true);
    }
}


