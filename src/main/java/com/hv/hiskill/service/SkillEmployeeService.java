package com.hv.hiskill.service;

import com.hv.hiskill.dto.EmployeeSkillDto;
import com.hv.hiskill.model.SkillEmployee;

import java.util.List;

public interface SkillEmployeeService {
    List<SkillEmployee> getAllSkillEmployees();

    SkillEmployee createSkillEmployee(SkillEmployee employee);

    List<EmployeeSkillDto> getEmployeeSkills(Long empId);

    SkillEmployee updateSkillEmployee(Long id, SkillEmployee employeeDetails);

    void deleteSkillEmployee(Long id);
}
