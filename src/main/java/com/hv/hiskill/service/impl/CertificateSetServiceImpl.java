package com.hv.hiskill.service.impl;


import com.hv.hiskill.model.CertificateSet;
import com.hv.hiskill.repository.CertificateSetRepository;
import com.hv.hiskill.service.CertificateSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateSetServiceImpl implements CertificateSetService {

    private CertificateSetRepository certificateSetRepository;

    @Autowired
    public void CertificateSetServiceImpl(CertificateSetRepository certificateSetRepository) {
        this.certificateSetRepository = certificateSetRepository;
    }

    public List<CertificateSet> getAllCertificates() {
        return certificateSetRepository.findAll();
    }

    public Optional<CertificateSet> getCertificateById(long id) {
        return certificateSetRepository.findById((int) id);
    }

    public CertificateSet createCertificate(CertificateSet certificate) {
        return certificateSetRepository.save(certificate);
    }

    public CertificateSet updateCertificate(Integer id, CertificateSet updatedCertificate) {
        Optional<CertificateSet> optionalCertificate = certificateSetRepository.findById(id);
        if (optionalCertificate.isPresent()) {
            CertificateSet certificate = optionalCertificate.get();
            // Update the properties of the certificate
            certificate.setCertificateName(updatedCertificate.getCertificateName());
            certificate.setDescription(updatedCertificate.getDescription());
            certificate.setVendor(updatedCertificate.getVendor());
            certificate.setCop(updatedCertificate.getCop());
            certificate.setSubCop(updatedCertificate.getSubCop());
            certificate.setCategory(updatedCertificate.getCategory());
            certificate.setCreatedBy(updatedCertificate.getCreatedBy());
            certificate.setUpdatedBy(updatedCertificate.getUpdatedBy());
            certificate.setCreatedDate(updatedCertificate.getCreatedDate());
            certificate.setUpdatedDate(updatedCertificate.getUpdatedDate());

            return certificateSetRepository.save(certificate);
        }
        return null;
    }


    public void deleteCertificate(long id) {
        certificateSetRepository.deleteById((int) id);
    }
}