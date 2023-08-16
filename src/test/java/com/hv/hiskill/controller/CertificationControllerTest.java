
package com.hv.hiskill.controller;

import com.hv.hiskill.dto.CertificationsDto;
import com.hv.hiskill.model.Certifications;
import com.hv.hiskill.service.CertificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CertificationControllerTest {

    private CertificationController certificationController;

    @Mock
    private CertificationService certificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        certificationController = new CertificationController(certificationService);
    }

    @Test
    void testGetAllCertifications() {

        List<Certifications> certificationsList = new ArrayList<>();
        certificationsList.add(new Certifications(1L, "Certification 1"));
        certificationsList.add(new Certifications(2L, "Certification 2"));

        when(certificationService.getAllCertifications()).thenReturn(certificationsList);


        ResponseEntity<List<Certifications>> responseEntity = certificationController.getAllCertifications();


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(certificationsList, responseEntity.getBody());
        verify(certificationService, times(1)).getAllCertifications();
    }

    @Test
    void testAddCertification() {

        Certifications certification = new Certifications(1L, "Certification");

        when(certificationService.addCertification(certification)).thenReturn(certification);


        ResponseEntity<Certifications> responseEntity = certificationController.addCertification(certification);


        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(certification, responseEntity.getBody());
        verify(certificationService, times(1)).addCertification(certification);
    }

    @Test
    void testGetCertificationdetails() {

        Long empId = 1L;
        List<CertificationsDto> certificationsDtoList = new ArrayList<>();
        certificationsDtoList.add(new CertificationsDto("Certification 1", "http://cert1.com", new Date()));
        certificationsDtoList.add(new CertificationsDto("Certification 2", "http://cert2.com", new Date()));

        when(certificationService.getCertificationDetails(empId)).thenReturn(certificationsDtoList);


        List<CertificationsDto> result = certificationController.getCertificationdetails(empId);

        assertEquals(certificationsDtoList, result);
        verify(certificationService, times(1)).getCertificationDetails(empId);
    }
}
