package com.hv.hiskill.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;


@JsonPropertyOrder({"id", "skillname", "about", "learning", "totalTime","articles", "exercises", "certificate", "plan"})
@Document(collection = "courses")
public class Course {
    @Id
    private String id;

    private String skillname;
    private String about;
    private List<String> learning;
    private String totalTime;
    private String articles;
    private String exercises;
    private String certificate;
    private Map<String, CourseWeek> plan;

    public Course() {
    }

    public Course(String id, String skillname, String about, List<String> learning, String totalTime,String articles, String exercises, String certificate, Map<String, CourseWeek>plan) {
        this.id = id;
        this.skillname = skillname;
        this.about = about;
        this.learning = learning;
        this.totalTime = totalTime;
        this.articles = articles;
        this.exercises = exercises;
        this.certificate = certificate;
        this.plan = plan;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<String> getLearning() {
        return learning;
    }

    public void setLearning(List<String> learning) {
        this.learning = learning;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getArticles() {
        return articles;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }

    public String getExercises() {
        return exercises;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Map<String, CourseWeek> getPlan() {
        return plan;
    }

    public void setPlan(Map<String, CourseWeek> plan) {
        this.plan = plan;
    }

}
