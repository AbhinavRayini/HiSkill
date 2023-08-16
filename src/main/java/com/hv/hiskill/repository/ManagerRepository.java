package com.hv.hiskill.repository;

import com.hv.hiskill.dto.EmployeeSkillManagerDto;
import com.hv.hiskill.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Employee,Integer> {
    //List<Employee> findBymanagerid(Integer managerId);
    @Query("SELECT new com.hv.hiskill.dto.EmployeeSkillManagerDto(e.empId, sem.skillId, sem.proficiencyLevel, sem.yearsOfExperience) FROM Employee e JOIN SkillEmployee sem ON " +
            "e.empId = sem.empId WHERE e.managerId = :managerId")
    public List<EmployeeSkillManagerDto> getEmployeesByManager(@Param("managerId") Integer managerId);
}
