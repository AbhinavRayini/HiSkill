package com.hv.hiskill.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.Date;


@Entity
@Table(name = "skill_employee_mapping")
public class SkillEmployee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Skill_id")
    private Integer skillId;
    @Column(name = "Emp_id")
    private Long empId;

    @Column(name = "Proficiency_level")
    private Integer proficiencyLevel;
    @Column(name = "Last_used")
    private Date lastUsed;
    @Column(name = "Created_by")
    private String createdBy;
    @CreationTimestamp
    @Column(name = "Created_date")
    private LocalDate createdDate;
    @Column(name = "Updated_by")
    private String updatedBy;
    @UpdateTimestamp
    @Column(name = "Updated_date")
    private LocalDate updatedDate;
    @Column(name = "YOE")
    private Integer yearsOfExperience;

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "SkillEmployee{" +
                "id=" + id +
                ", skillId=" + skillId +
                ", empId=" + empId +
                ", proficiencyLevel=" + proficiencyLevel +
                ", lastUsed=" + lastUsed +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

    public Long getEmpId() {
        return empId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }


    public SkillEmployee(Long id, Integer skillId, Long empId, Integer proficiencyLevel, Date lastUsed, String createdBy, LocalDate createdDate, String updatedBy, LocalDate updatedDate) {
        this.id = id;
        this.skillId = skillId;
        this.empId = empId;
        this.proficiencyLevel = proficiencyLevel;
        this.lastUsed = lastUsed;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public SkillEmployee(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public SkillEmployee() {

    }

    public Long getId() {
        return id;
    }


}
