package com.hv.hiskill.dto;

import java.util.Date;

public class SkillEmployeeDto2 {

    private Long empId;
    private String empName;
    private Integer skillId;
    private Integer proficiencyLevel;
    private Date lastUsed;

    public SkillEmployeeDto2(Long empId, String empName, Integer skillId, Integer proficiencyLevel, Date lastUsed) {
        this.empId = empId;
        this.empName = empName;
        this.skillId = skillId;
        this.proficiencyLevel = proficiencyLevel;
        this.lastUsed = lastUsed;
    }

    public SkillEmployeeDto2() {
    }

    public SkillEmployeeDto2(String empName,Integer skillId) {
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(Integer proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }

}
