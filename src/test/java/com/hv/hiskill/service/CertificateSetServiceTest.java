package com.hv.hiskill.service;


import com.hv.hiskill.repository.CertificateSetRepository;
import com.hv.hiskill.model.CertificateSet;
import com.hv.hiskill.service.impl.CertificateSetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CertificateSetServiceTest {

    @Mock
    private CertificateSetRepository certificateSetRepository;

    @InjectMocks
    private CertificateSetServiceImpl certificateSetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCertificates() {
        // Arrange
        List<CertificateSet> expectedCertificates = new ArrayList<>();
        expectedCertificates.add(new CertificateSet());
        when(certificateSetRepository.findAll()).thenReturn(expectedCertificates);

        // Act
        List<CertificateSet> actualCertificates = certificateSetService.getAllCertificates();

        // Assert
        assertEquals(expectedCertificates, actualCertificates);
        verify(certificateSetRepository, times(1)).findAll();
    }

    @Test
    void testGetCertificateById() {
        // Arrange
        long certificateId = 1;
        CertificateSet expectedCertificate = new CertificateSet();
        when(certificateSetRepository.findById((int) certificateId)).thenReturn(Optional.of(expectedCertificate));

        // Act
        Optional<CertificateSet> actualCertificate = certificateSetService.getCertificateById(certificateId);

        // Assert
        assertTrue(actualCertificate.isPresent());
        assertEquals(expectedCertificate, actualCertificate.get());
        verify(certificateSetRepository, times(1)).findById((int) certificateId);
    }

    @Test
    void testCreateCertificate() {
        // Arrange
        CertificateSet certificateToCreate = new CertificateSet();
        when(certificateSetRepository.save(any(CertificateSet.class))).thenReturn(certificateToCreate);

        // Act
        CertificateSet createdCertificate = certificateSetService.createCertificate(certificateToCreate);

        // Assert
        assertNotNull(createdCertificate);
        assertEquals(certificateToCreate, createdCertificate);
        verify(certificateSetRepository, times(1)).save(certificateToCreate);
    }

    @Test
    void testUpdateCertificate() {
        // Arrange
        Integer certificateId = 1;
        CertificateSet existingCertificate = new CertificateSet();
        when(certificateSetRepository.findById(certificateId)).thenReturn(Optional.of(existingCertificate));
        when(certificateSetRepository.save(any(CertificateSet.class))).thenReturn(existingCertificate);

        CertificateSet updatedCertificate = new CertificateSet();
        updatedCertificate.setCertificateName("Updated Certificate");

        // Act
        CertificateSet result = certificateSetService.updateCertificate(certificateId, updatedCertificate);

        // Assert
        assertNotNull(result);
        assertEquals(updatedCertificate.getCertificateName(), result.getCertificateName());
        verify(certificateSetRepository, times(1)).findById(certificateId);
        verify(certificateSetRepository, times(1)).save(existingCertificate);
    }

    @Test
    void testDeleteCertificate() {
        // Arrange
        long certificateId = 1;

        // Act
        certificateSetService.deleteCertificate(certificateId);

        /// Assert
        verify(certificateSetRepository, times(1)).deleteById((int) certificateId);
    }
}