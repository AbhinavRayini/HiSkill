package com.hv.hiskill.controller;

import com.hv.hiskill.model.CertificateSet;
import com.hv.hiskill.service.CertificateSetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CertificateSetControllerTest {

    @Mock
    private CertificateSetService certificatesetService;

    private CertificateSetController certificateController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        certificateController = new CertificateSetController(certificatesetService);
    }

    @Test
    void testGetAllCertificates() {
        List<CertificateSet> expectedCertificates = Arrays.asList(
                new CertificateSet(1, "Certificate 1"),
                new CertificateSet(2, "Certificate 2")
        );

        when(certificatesetService.getAllCertificates()).thenReturn(expectedCertificates);

        List<CertificateSet> actualCertificates = certificateController.getAllCertificates();

        assertEquals(expectedCertificates, actualCertificates);
        verify(certificatesetService, times(1)).getAllCertificates();
    }

    @Test
    void testGetCertificateById() {
        Integer id = 1;
        CertificateSet expectedCertificate = new CertificateSet(id, "Certificate 1");

        when(certificatesetService.getCertificateById(id)).thenReturn(Optional.of(expectedCertificate));

        Optional<CertificateSet> actualCertificate = certificateController.getCertificateById(id);

        assertEquals(Optional.of(expectedCertificate), actualCertificate);
        verify(certificatesetService, times(1)).getCertificateById(id);
    }

    @Test
    void testCreateCertificate() {
        CertificateSet certificateToCreate = new CertificateSet(1, "Certificate 1");
        CertificateSet expectedCreatedCertificate = new CertificateSet(1, "Certificate 1");

        when(certificatesetService.createCertificate(certificateToCreate)).thenReturn(expectedCreatedCertificate);

        CertificateSet actualCreatedCertificate = certificateController.createCertificate(certificateToCreate);

        assertEquals(expectedCreatedCertificate, actualCreatedCertificate);
        verify(certificatesetService, times(1)).createCertificate(certificateToCreate);
    }

    @Test
    void testUpdateCertificate() {
        Integer id = 1;
        CertificateSet updatedCertificate = new CertificateSet(id, "Updated Certificate");

        when(certificatesetService.updateCertificate(id, updatedCertificate)).thenReturn(updatedCertificate);

        CertificateSet actualUpdatedCertificate = certificateController.updateCertificate(id, updatedCertificate);

        assertEquals(updatedCertificate, actualUpdatedCertificate);
        verify(certificatesetService, times(1)).updateCertificate(id, updatedCertificate);
    }

    @Test
    void testDeleteCertificate() {
        Integer id = 1;

        certificateController.deleteCertificate(id);

        verify(certificatesetService, times(1)).deleteCertificate(id);
    }
}
