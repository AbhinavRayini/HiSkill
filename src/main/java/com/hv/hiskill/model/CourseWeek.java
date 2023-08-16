package com.hv.hiskill.model;

import java.util.Map;

public class CourseWeek {


    private String label;
    private String about;
    private Map<String, Courseday> days;
    public CourseWeek() {
    }

    public CourseWeek(String label, String about, Map<String,Courseday> days) {
        this.label = label;
        this.about = about;
        this.days = days;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Map<String, Courseday> getDays() {
        return days;
    }

    public void setDays(Map<String, Courseday> days) {
        this.days = days;
    }
}