package com.hv.hiskill.dto;

import java.util.Date;

public class CertificationsDto {

    private String certificationName;

    private String certificationUrl;

    public String getCertificationUrl() {
        return certificationUrl;
    }

    public void setCertificationUrl(String certificationUrl) {
        this.certificationUrl = certificationUrl;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    private Date expiredDate;

    public CertificationsDto() {
    }

    @Override
    public String toString() {
        return "certificationsdto{" +
                "certificationName='" + certificationName + '\'' +
                ", certificationUrl='" + certificationUrl + '\'' +
                ", expiredDate=" + expiredDate +
                '}';
    }

    public CertificationsDto(String certificationName, String certificationUrl, Date expiredDate) {
        this.certificationName = certificationName;
        this.certificationUrl = certificationUrl;
        this.expiredDate = expiredDate;
    }


    public String getCertificationName() {
        return certificationName;
    }

    public void setCertificationName(String certificationId) {
        this.certificationName = certificationName;
    }
}
