package com.hv.hiskill.service;


import com.hv.hiskill.dto.CertificationsDto;
import com.hv.hiskill.model.Certifications;

import java.util.List;

public interface CertificationService {
    List<Certifications> getAllCertifications();

    Certifications addCertification(Certifications certification);

    List<CertificationsDto> getCertificationDetails(Long empId);
}

