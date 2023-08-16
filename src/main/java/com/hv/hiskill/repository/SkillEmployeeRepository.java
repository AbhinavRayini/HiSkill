package com.hv.hiskill.repository;

import com.hv.hiskill.dto.EmployeeSkillDto;
import com.hv.hiskill.dto.SkillEmployeeDto2;
import com.hv.hiskill.dto.SkillEmployeeDto3;
import com.hv.hiskill.dto.SkillEmployeeDto4;
import com.hv.hiskill.model.SkillEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillEmployeeRepository extends JpaRepository<SkillEmployee,Long> {


    @Query("SELECT new com.hv.hiskill.dto.SkillEmployeeDto2(e.empId, e.empName, sem.skillId, sem.proficiencyLevel, sem.lastUsed) " +
            "FROM SkillEmployee sem " +
            "JOIN Employee e ON e.empId = sem.empId " +
            "JOIN SkillSet ss ON ss.skillId = sem.skillId " +
            "WHERE ss.skillName = :skillName")
    List<SkillEmployeeDto2> findBySkillName(@Param("skillName") String skillName);

    @Query("SELECT new com.hv.hiskill.dto.EmployeeSkillDto(s.id,s.empId, s.skillId, s.proficiencyLevel, s.lastUsed,s.yearsOfExperience, ss.skillName) " +
            "FROM SkillEmployee s " +
            "JOIN SkillSet ss ON s.skillId = ss.skillId " +
            "WHERE s.empId = :empId")
    List<EmployeeSkillDto> getEmployeeSkills(@Param("empId") Long empId);
    @Query("SELECT new com.hv.hiskill.dto.SkillEmployeeDto3( e.empName, sem.skillId, sem.proficiencyLevel, ss.skillName,e.empId) " +
            "FROM SkillEmployee sem " +
            "JOIN Employee e ON e.empId = sem.empId " +
            "JOIN SkillSet ss ON ss.skillId = sem.skillId " )
    List<SkillEmployeeDto3> findBySkillLen();

    @Query("SELECT new com.hv.hiskill.dto.SkillEmployeeDto4(sem.skillId, COUNT(sem.skillId) AS frequency, sm.skillName) " +
            "FROM SkillEmployee sem " +
            "JOIN Employee e ON e.empId = sem.empId " +
            "JOIN SkillSet sm ON sm.skillId = sem.skillId " +
            "GROUP BY sem.skillId, sm.skillName")
    List<SkillEmployeeDto4> findByCount();
}
