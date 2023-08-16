package com.hv.hiskill.dto;

public class SkillEmployeeDto4 {

    private Integer skillId;

    private Long frequency;

    private String skillName;

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public SkillEmployeeDto4(Integer skillId, Long frequency, String skillName) {
        this.skillId = skillId;
        this.frequency = frequency;
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "SkillEmployeeDto4{" +
                "skillId=" + skillId +
                ", Frequency=" + frequency +
                ", skillName='" + skillName + '\'' +
                '}';
    }

    public SkillEmployeeDto4() {
    }
}
