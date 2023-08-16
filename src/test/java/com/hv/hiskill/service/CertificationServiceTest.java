package com.hv.hiskill.service;

import com.hv.hiskill.dto.CertificationsDto;
import com.hv.hiskill.model.Certifications;
import com.hv.hiskill.repository.CertificationsRepository;
import com.hv.hiskill.service.CertificationService;
import com.hv.hiskill.service.impl.CertificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CertificationServiceTest {

    @Mock
    private CertificationsRepository certificationRepository;

    @InjectMocks
    private CertificationServiceImpl certificationService;
    // private CertificationService certificationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCertifications() {
        // Mock data
        Certifications certification1 = new Certifications();
        certification1.setId(1L);
        Certifications certification2 = new Certifications();
        certification2.setId(2L);
        List<Certifications> certificationsList = new ArrayList<>();
        certificationsList.add(certification1);
        certificationsList.add(certification2);

        // Mock the repository method
        when(certificationRepository.findAll()).thenReturn(certificationsList);

        // Call the service method
        List<Certifications> result = certificationService.getAllCertifications();

        // Verify the repository method was called
        verify(certificationRepository, times(1)).findAll();

        // Verify the result
        assertEquals(certificationsList, result);
    }

    @Test
    public void testAddCertification() {
        // Mock data
        Certifications certification = new Certifications();
        certification.setId(1L);

        // Mock the repository method
        when(certificationRepository.save(certification)).thenReturn(certification);

        // Call the service method
        Certifications result = certificationService.addCertification(certification);

        // Verify the repository method was called
        verify(certificationRepository, times(1)).save(certification);

        // Verify the result
        assertEquals(certification, result);
    }

    @Test
    public void testGetCertificationDetails() {
        // Mock data
        Long empId = 1L;
        List<CertificationsDto> certificationsDtoList = new ArrayList<>();

        // Mock the repository method
        when(certificationRepository.getCertificationdetails(empId)).thenReturn(certificationsDtoList);

        // Call the service method
        List<CertificationsDto> result = certificationService.getCertificationDetails(empId);

        // Verify the repository method was called
        verify(certificationRepository, times(1)).getCertificationdetails(empId);

        // Verify the result
        assertEquals(certificationsDtoList, result);
    }
}
