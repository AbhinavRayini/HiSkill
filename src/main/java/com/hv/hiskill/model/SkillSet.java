package com.hv.hiskill.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.List;

@Entity
@Table(name = "Skill_Master")
public class SkillSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Skill_id")
    private Integer skillId;
    @Column(name = "Skill_name")
    private String skillName;
    @Column(name = "Skill_version")
    private String skillVersion;
    @Column(name = "Category")
    private String category;
    @Column(name = "Subcop")
    private String subCop;
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
    @Column(name = "Cop")
    private String cop;


    @OneToMany(targetEntity = SkillEmployee.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "Skill_id", referencedColumnName = "Skill_id")
    private List<SkillEmployee> SkillEmployees;

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillVersion() {
        return skillVersion;
    }

    public void setSkillVersion(String skillVersion) {
        this.skillVersion = skillVersion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCop() {
        return subCop;
    }

    public void setSubCop(String subCop) {
        this.subCop = subCop;
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

    public String getCop() {
        return cop;
    }

    public void setCop(String cop) {
        this.cop = cop;
    }


    public SkillSet(Integer skillId, String skillName, String skillVersion, String category, String subCop, String createdBy, LocalDate createdDate, String updatedBy, LocalDate updatedDate, String cop) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillVersion = skillVersion;
        this.category = category;
        this.subCop = subCop;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.cop = cop;
    }

    @Override
    public String toString() {
        return "skillset{" +
                "skillid=" + skillId +
                ", skillname='" + skillName + '\'' +
                ", skillversion='" + skillVersion + '\'' +
                ", category='" + category + '\'' +
                ", subcop='" + subCop + '\'' +
                ", createdby='" + createdBy + '\'' +
                ", createddate=" + createdDate +
                ", updatedby='" + updatedBy + '\'' +
                ", updateddate=" + updatedDate +
                ", cop='" + cop + '\'' +

                '}';
    }

    public SkillSet() {
    }
}