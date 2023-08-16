package com.hv.hiskill.repository;

import com.hv.hiskill.model.CertificateSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateSetRepository extends JpaRepository<CertificateSet, Integer>{


}