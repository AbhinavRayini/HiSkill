package com.hv.hiskill.model;

import java.util.List;

public class Courseday {
    private String dLabel;
    private String name;
    private List<String> details;
    private List<String> mode;
    int time;
    private List<String> prerequisites ;
    private List<String> references;

    public Courseday() {
    }

    public Courseday(String dLabel, String name, List<String> details , List<String>  mode, int time, List<String>  prerequisites, List<String> references ) {
        this.dLabel = dLabel;
        this.name = name;
        this.details = details;
        this.mode = mode;
        this.time = time;
        this.prerequisites = prerequisites;
        this.references = references;
    }

    public String getdLabel() {
        return dLabel;
    }

    public void setdLabel(String dLabel) {
        this.dLabel = dLabel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public List<String> getMode() {
        return mode;
    }

    public void setMode(List<String> mode) {
        this.mode = mode;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }
}