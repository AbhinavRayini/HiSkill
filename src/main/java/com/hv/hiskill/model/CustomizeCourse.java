package com.hv.hiskill.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Document(collection = "CustomizeCourse")
public class CustomizeCourse {
    @Id
    private String id;
    private String employeeName;
    private List<String> topics;

    public CustomizeCourse() {
    }
    public CustomizeCourse(String id, String employeeName, List<String> topics) {
        this.id = id;
        this.employeeName = employeeName;
        this.topics = topics;

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

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }
}


