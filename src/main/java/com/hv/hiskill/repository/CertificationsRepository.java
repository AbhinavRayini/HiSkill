package com.hv.hiskill.repository;


import com.hv.hiskill.dto.CertificationsDto;
import com.hv.hiskill.model.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificationsRepository extends JpaRepository<Certifications, Long> {


    List<Certifications> findByEmpId(Long empId);

    @Query("SELECT new com.hv.hiskill.dto.CertificationsDto( c.certificationName,c.certificationUrl, c.expiredDate) FROM" +
            " Certifications c WHERE c.empId = :empId")
    List<CertificationsDto> getCertificationdetails(Long empId);

}
