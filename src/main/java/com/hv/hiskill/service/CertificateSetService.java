package com.hv.hiskill.service;

import com.hv.hiskill.model.CertificateSet;

import java.util.List;
import java.util.Optional;

public interface CertificateSetService {
    List<CertificateSet> getAllCertificates();

    Optional<CertificateSet> getCertificateById(long id);

    CertificateSet createCertificate(CertificateSet certificate);

    CertificateSet updateCertificate(Integer id, CertificateSet updatedCertificate);

    void deleteCertificate(long id);
}
