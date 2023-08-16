package com.hv.hiskill.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CertificateSetTest {

    @Test
    public void testCertificateSetConstructorAndGetters() {
        // Arrange
        Integer id = 1;
        String certificateName = "Test Certificate";
        String description = "Certificate description";
        String vendor = "Test Vendor";
        String cop = "Test COP";
        String subCop = "Test SubCOP";
        String category = "Test Category";
        String createdBy = "Test User";
        String updatedBy = "Test User";
        LocalDate createdDate = LocalDate.now();
        LocalDate updatedDate = LocalDate.now();

        // Act
        CertificateSet certificateSet = new CertificateSet(id, certificateName, description, vendor, cop, subCop, category, createdBy, updatedBy, createdDate, updatedDate);

        // Assert
        Assertions.assertEquals(id, certificateSet.getId());
        Assertions.assertEquals(certificateName, certificateSet.getCertificateName());
        Assertions.assertEquals(description, certificateSet.getDescription());
        Assertions.assertEquals(vendor, certificateSet.getVendor());
        Assertions.assertEquals(cop, certificateSet.getCop());
        Assertions.assertEquals(subCop, certificateSet.getSubCop());
        Assertions.assertEquals(category, certificateSet.getCategory());
        Assertions.assertEquals(createdBy, certificateSet.getCreatedBy());
        Assertions.assertEquals(updatedBy, certificateSet.getUpdatedBy());
        Assertions.assertEquals(createdDate, certificateSet.getCreatedDate());
        Assertions.assertEquals(updatedDate, certificateSet.getUpdatedDate());
    }

    @Test
    public void testCertificateSetDefaultConstructor() {
        // Arrange
        Integer expectedId = null;
        String expectedCertificateName = null;
        String expectedDescription = null;
        String expectedVendor = null;
        String expectedCop = null;
        String expectedSubCop = null;
        String expectedCategory = null;
        String expectedCreatedBy = null;
        String expectedUpdatedBy = null;
        LocalDate expectedCreatedDate = null;
        LocalDate expectedUpdatedDate = null;

        // Act
        CertificateSet certificateSet = new CertificateSet();

        // Assert
        Assertions.assertEquals(expectedId, certificateSet.getId());
        Assertions.assertEquals(expectedCertificateName, certificateSet.getCertificateName());
        Assertions.assertEquals(expectedDescription, certificateSet.getDescription());
        Assertions.assertEquals(expectedVendor, certificateSet.getVendor());
        Assertions.assertEquals(expectedCop, certificateSet.getCop());
        Assertions.assertEquals(expectedSubCop, certificateSet.getSubCop());
        Assertions.assertEquals(expectedCategory, certificateSet.getCategory());
        Assertions.assertEquals(expectedCreatedBy, certificateSet.getCreatedBy());
        Assertions.assertEquals(expectedUpdatedBy, certificateSet.getUpdatedBy());
        Assertions.assertEquals(expectedCreatedDate, certificateSet.getCreatedDate());
        Assertions.assertEquals(expectedUpdatedDate, certificateSet.getUpdatedDate());
    }

    @Test
    public void testCertificateSetSetters() {
        // Arrange
        CertificateSet certificateSet = new CertificateSet();
        Integer id = 1;
        String certificateName = "Test Certificate";
        String description = "Certificate description";
        String vendor = "Test Vendor";
        String cop = "Test COP";
        String subCop = "Test SubCOP";
        String category = "Test Category";
        String createdBy = "Test User";
        String updatedBy = "Test User";
        LocalDate createdDate = LocalDate.now();
        LocalDate updatedDate = LocalDate.now();

        // Act
        certificateSet.setId(id);
        certificateSet.setCertificateName(certificateName);
        certificateSet.setDescription(description);
        certificateSet.setVendor(vendor);
        certificateSet.setCop(cop);
        certificateSet.setSubCop(subCop);
        certificateSet.setCategory(category);
        certificateSet.setCreatedBy(createdBy);
        certificateSet.setUpdatedBy(updatedBy);
        certificateSet.setCreatedDate(createdDate);
        certificateSet.setUpdatedDate(updatedDate);

        // Assert
        Assertions.assertEquals(id, certificateSet.getId());
        Assertions.assertEquals(certificateName, certificateSet.getCertificateName());
        Assertions.assertEquals(description, certificateSet.getDescription());
        Assertions.assertEquals(vendor, certificateSet.getVendor());
        Assertions.assertEquals(cop, certificateSet.getCop());
        Assertions.assertEquals(subCop, certificateSet.getSubCop());
        Assertions.assertEquals(category, certificateSet.getCategory());
        Assertions.assertEquals(createdBy, certificateSet.getCreatedBy());
        Assertions.assertEquals(updatedBy, certificateSet.getUpdatedBy());
        Assertions.assertEquals(createdDate, certificateSet.getCreatedDate());
        Assertions.assertEquals(updatedDate, certificateSet.getUpdatedDate());
    }

//    @Test
//    public void testCertificateSetToString() {
//        // Arrange
//        Integer id = 1;
//        String certificateName = "Test Certificate";
//        String description = "Certificate description";
//        String vendor = "Test Vendor";
//        String cop = "Test COP";
//        String subCop = "Test SubCOP";
//        String category = "Test Category";
//        String createdBy = "Test User";
//        String updatedBy = "Test User";
//        LocalDate createdDate = LocalDate.now();
//        LocalDate updatedDate = LocalDate.now();
//        CertificateSet certificateSet = new CertificateSet(id, certificateName, description, vendor, cop, subCop, category, createdBy, updatedBy, createdDate, updatedDate);
//        String expectedToString = "CertificateSet{" +
//                "id=" + id +
//                ", certificateName='" + certificateName + '\'' +
//                ", description='" + description + '\'' +
//                ", vendor='" + vendor + '\'' +
//                ", cop='" + cop + '\'' +
//                ", subCop='" + subCop + '\'' +
//                ", category='" + category + '\'' +
//                ", createdBy='" + createdBy + '\'' +
//                ", updatedBy='" + updatedBy + '\'' +
//                ", createdDate=" + createdDate +
//                ", updatedDate=" + updatedDate +
//                '}';
//
//
//        String actualToString = certificateSet.toString();
//
//
//        Assertions.assertEquals(expectedToString, actualToString);
//    }
}
