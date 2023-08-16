package com.hv.hiskill.dto;

public class SkillEmployeeDto3 {
    private String empName;
    private Integer skillId;
    private Integer proficiencyLevel;
    private String skillName;

    private Long empId;

    public SkillEmployeeDto3(String empName, Integer skillId,Integer proficiencyLevel) {
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

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "SkillEmployeeDto3{" +
                "empName='" + empName + '\'' +
                ", skillId=" + skillId +
                ", proficiencyLevel=" + proficiencyLevel +
                ", skillName='" + skillName + '\'' +
                ", empId=" + empId +
                '}';
    }

    public SkillEmployeeDto3(String empName, Integer skillId, Integer proficiencyLevel, String skillName,Long empId) {
        this.empName = empName;
        this.skillId = skillId;
        this.proficiencyLevel = proficiencyLevel;
        this.skillName = skillName;
        this.empId=empId;
    }
}
