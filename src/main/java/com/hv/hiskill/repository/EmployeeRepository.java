package com.hv.hiskill.repository;

import com.hv.hiskill.dto.EmployeeDto;
import com.hv.hiskill.model.Employee;
//import com.hv.hiskill.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.hv.hiskill.dto.EmployeeDto(e.empId, e.empName) FROM Employee e JOIN Certifications c ON " +
            "e.empId = c.empId WHERE c.certificationName = :certificationName")
    public List<EmployeeDto> getCertificates(@Param("certificationName") String certificationName);
    Optional<Employee> findByEmpName(String empName); // Updated method name to match property

    Boolean existsByEmpName(String empName); // Updated method name to match property

    Boolean existsByEmail(String email);
}
