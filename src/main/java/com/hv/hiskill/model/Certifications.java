package com.hv.hiskill.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.Date;

@Entity
@Table(name = "Certification_Emp_Mapping")
public class Certifications {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Emp_id")//unique = true, insertable =false, updatable = false)
    private Long empId;
    @Column(name = "Cert_id")
    private Integer certId;

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Acquired_date")
    private Date acquiredDate;
    @Column(name = "Expire_date")
    private Date expiredDate;
    @Column(name = "Certification_name ")
    private String certificationName;
    @Column(name = "Certification_url")
    private String certificationUrl;

    @Column(name = "Created_by")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "Created_date")

    private LocalDate createdDate;
    @Column(name = "Updated_by")
    private String updatedBy;

    @Column(name = "Issued_org")
    private String issuedOrganization;

    public Long getId() {
        return id;
    }


    public Certifications(long l, String certification) {
    }

    public String getIssuedOrganization() {
        return issuedOrganization;
    }

    public void setIssuedOrganization(String issuedOrganization) {
        this.issuedOrganization = issuedOrganization;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Integer getCertId() {
        return certId;
    }

    public void setCertId(Integer certId) {
        this.certId = certId;
    }

    public Date getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(Date acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }


    public String getCertificationName() {
        return certificationName;
    }

    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }


    public String getCertificationUrl() {
        return certificationUrl;
    }

    public void setCertificationUrl(String certificationUrl) {
        this.certificationUrl = certificationUrl;
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

    public Certifications() {
    }


    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Certifications(String issuedOrganization) {
        this.issuedOrganization = issuedOrganization;
    }

    public Certifications(Long empId, Integer certId, Date acquiredDate, Date expiredDate, String certificationId, String certificationUrl, String createdBy, LocalDate createdDate, String updatedBy, LocalDate updatedDate) {
        this.empId = empId;
        this.certId = certId;
        this.acquiredDate = acquiredDate;
        this.expiredDate = expiredDate;
        this.certificationName = certificationName;
        this.certificationUrl = certificationUrl;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    @UpdateTimestamp
    @Column(name = "Updated_date")

    private LocalDate updatedDate;


    @Override
    public String toString() {
        return "Certifications{" +
                "id=" + id +
                ", empId=" + empId +
                ", certId=" + certId +
                ", acquiredDate=" + acquiredDate +
                ", expiredDate=" + expiredDate +
                ", certificationName='" + certificationName + '\'' +
                ", certificationUrl='" + certificationUrl + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", issuedOrganization='" + issuedOrganization + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}

