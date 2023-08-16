package com.hv.hiskill.dto;

public class EmployeeSkillManagerDto {
    private Long empId;
    private Integer skillId;
    private Integer proficiencyLevel;


    private Integer yearsOfExperience;

    public EmployeeSkillManagerDto(Long empId, Integer skillId, Integer proficiencyLevel , Integer yearsOfExperience) {
        this.empId = empId;
        this.skillId = skillId;
        this.proficiencyLevel = proficiencyLevel;
        this.yearsOfExperience=yearsOfExperience;
    }

    public EmployeeSkillManagerDto() {

    }


    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }


    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Integer getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(Integer proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }
    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    @Override
    public String toString() {
        return "EmployeeSkillManagerDto{" +
                "empId=" + empId +
                ", skillId=" + skillId +
                ", proficiencyLevel=" + proficiencyLevel +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

}
