package com.hv.hiskill.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "Emp_id", nullable = false, unique = true)
    private Long empId;
    @Column(name = "Emp_name")
    private String empName;
    @Column(name = "COP")
    private String cop;
    @Column(name = "Sub_Cop")
    private String subCop;
    @Column(name = "Job_title")
    private String jobTitle;
    @Column(name = "Role")
    private String role;
    @Column(name = "Manager_id")
    private Integer managerId;
    @Column(name = "Created_by")
    private String createdBy;
    @Column(name = "Created_date")
    @CreationTimestamp
    private LocalDate createdDate;
    @Column(name = "Updated_by")
    private String updatedBy;
    @Column(name = "Updated_date")
    @UpdateTimestamp
    private LocalDate updatedDate;

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "Email")
    private String email;

    @NotBlank
    @Size(max = 120)
    @Column(name = "Password")
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Skill_id")
    private SkillEmployee skill;

    @OneToMany(targetEntity = SkillEmployee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id", referencedColumnName = "Emp_id")
    private List<SkillEmployee> SkillEmployees;

    @OneToMany(targetEntity = Certifications.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_id", referencedColumnName = "Emp_id")
    private List<Certifications> certificationsList;




    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "emp_roles",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();



    public Employee() {
    }

    public Employee(Long empId, String empName, String cop, String subCop, String jobTitle, String role, Integer managerId, String createdBy, LocalDate createdDate, String updatedBy, LocalDate updatedDate, SkillEmployee skill, List<SkillEmployee> skillEmployees, List<Certifications> certificationsList, String email, String password, Set<Role> roles) {
        this.empId = empId;
        this.empName = empName;
        this.cop = cop;
        this.subCop = subCop;
        this.jobTitle = jobTitle;
        this.role = role;
        this.managerId = managerId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.skill = skill;
        SkillEmployees = skillEmployees;
        this.certificationsList = certificationsList;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Employee(String empName, String email, String encode) {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", cop='" + cop + '\'' +
                ", subCop='" + subCop + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", role='" + role + '\'' +
                ", managerId=" + managerId +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", skill=" + skill +
                ", SkillEmployees=" + SkillEmployees +
                ", certificationsList=" + certificationsList +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
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

    public String getCop() {
        return cop;
    }

    public void setCop(String cop) {
        this.cop = cop;
    }

    public String getSubCop() {
        return subCop;
    }

    public void setSubCop(String subCop) {
        this.subCop = subCop;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
