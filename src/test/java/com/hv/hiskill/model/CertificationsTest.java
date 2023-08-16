package com.hv.hiskill.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class CertificationsTest {

    @Test
    public void testToString() {
        Certifications certifications = new Certifications();

        // Set values for the attributes
        certifications.setId(1L);
        certifications.setEmpId(1001L);
        certifications.setCertId(12345);
        certifications.setAcquiredDate(new Date());
        certifications.setExpiredDate(new Date());
        certifications.setCertificationName("Java Certification");
        certifications.setCertificationUrl("https://example.com/certification");
        certifications.setCreatedBy("John Doe");
        certifications.setCreatedDate(LocalDate.now());
        certifications.setUpdatedBy("Jane Smith");
        certifications.setIssuedOrganization("Certification Organization");
        certifications.setUpdatedDate(LocalDate.now());

        // Define the expected output of the toString() method
        String expectedOutput = "Certifications{" +
                "id=1, " +
                "empId=1001, " +
                "certId=12345, " +
                "acquiredDate=" + certifications.getAcquiredDate() + ", " +
                "expiredDate=" + certifications.getExpiredDate() + ", " +
                "certificationName='Java Certification', " +
                "certificationUrl='https://example.com/certification', " +
                "createdBy='John Doe', " +
                "createdDate=" + certifications.getCreatedDate() + ", " +
                "updatedBy='Jane Smith', " +
                "issuedOrganization='Certification Organization', " +
                "updatedDate=" + certifications.getUpdatedDate() +
                "}";

        // Call the toString() method and assert the expected output
        Assert.assertEquals(expectedOutput, certifications.toString());
    }


}
