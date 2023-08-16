package com.hv.hiskill.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Certification_Master")
public class CertificateSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cert_id")
    private Integer id;

    @Column(name = "certificate_name")
    private String certificateName;

    @Column(name = "description")
    private String description;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "cop")
    private String cop;

    @Column(name = "subcop")
    private String subCop;

    @Column(name = "category")
    private String category;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "updatedBy")
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "createdDate")
    private LocalDate createdDate;
    @UpdateTimestamp
    @Column(name = "updatedDate")
    private LocalDate updatedDate;

    @OneToMany(targetEntity = Certifications.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Cert_id", referencedColumnName = "Cert_id")
    private List<Certifications> certifications;

    public CertificateSet(Integer certificateId, String certificate) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public CertificateSet(Integer id, String certificateName, String description, String vendor, String cop, String subCop, String category, String createdBy, String updatedBy, LocalDate createdDate, LocalDate updatedDate) {
        this.id = id;
        this.certificateName = certificateName;
        this.description = description;
        this.vendor = vendor;
        this.cop = cop;
        this.subCop = subCop;
        this.category = category;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "certificateset{" + "id=" + id + ", certificate_name='" + certificateName + '\'' + ", description='" + description + '\'' + ", vendor='" + vendor + '\'' + ", cop='" + cop + '\'' + ", subcop='" + subCop + '\'' + ", category='" + category + '\'' + ", created_by='" + createdBy + '\'' + ", updated_by='" + updatedBy + '\'' + ", created_date=" + createdDate + ", updated_date=" + updatedDate + '}';
    }

    public CertificateSet() {
    }
}