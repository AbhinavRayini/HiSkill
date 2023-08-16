package com.hv.hiskill.service.impl;

import com.hv.hiskill.dto.CertificationsDto;
import com.hv.hiskill.model.Certifications;
import com.hv.hiskill.repository.CertificationsRepository;
import com.hv.hiskill.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CertificationServiceImpl implements CertificationService {

    private final CertificationsRepository certificationRepository;

    @Autowired
    public CertificationServiceImpl(CertificationsRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    public List<Certifications> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Certifications addCertification(Certifications certification) {
        return certificationRepository.save(certification);
    }

    @Override
    public List<CertificationsDto> getCertificationDetails(Long empId) {
        return certificationRepository.getCertificationdetails(empId);
    }


}
