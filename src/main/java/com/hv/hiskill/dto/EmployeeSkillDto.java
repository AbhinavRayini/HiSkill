package com.hv.hiskill.dto;

import java.util.Date;

//@EntityScan

public class EmployeeSkillDto {
    private Long id;
    private Long empId;
    private Integer skillId;
    private Integer proficiencyLevel;
    private Date lastUsed;

    private Integer yearsOfExperience;

    private String skillName;

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public EmployeeSkillDto(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "EmployeeSkillDto{" +
                "id=" + id +
                ", empId=" + empId +
                ", skillId=" + skillId +
                ", proficiencyLevel=" + proficiencyLevel +
                ", lastUsed=" + lastUsed +
                ", yearsOfExperience=" + yearsOfExperience +
                ", skillName='" + skillName + '\'' +
                '}';
    }


    public EmployeeSkillDto(Long id, Long empId, Integer skillId, Integer proficiencyLevel, Date lastUsed, Integer yearsOfExperience, String skillName) {
        this.id = id;
        this.empId = empId;
        this.skillId = skillId;
        this.proficiencyLevel = proficiencyLevel;
        this.lastUsed = lastUsed;
        this.yearsOfExperience = yearsOfExperience;
        this.skillName = skillName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
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

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public EmployeeSkillDto() {
    }
}


