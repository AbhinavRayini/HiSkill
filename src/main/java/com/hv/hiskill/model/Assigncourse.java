package com.hv.hiskill.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Assigncourse")
public class Assigncourse {
    @Id
    private String id;
    private String employeeName;
    private String courseName;
    private String description;

    public Assigncourse() {
    }

    public Assigncourse(String id, String employeeName, String courseName, String description) {
        this.id = id;
        this.employeeName = employeeName;
        this.courseName = courseName;
        this.description = description;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}