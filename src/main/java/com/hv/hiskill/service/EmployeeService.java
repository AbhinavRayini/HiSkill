package com.hv.hiskill.service;


import com.hv.hiskill.dto.EmployeeDto;
import com.hv.hiskill.dto.EmployeeSkillManagerDto;
import com.hv.hiskill.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getCertificates(String certificationName);

    List<Employee> getAllDetails();

    List<EmployeeSkillManagerDto> getEmployeesByManager(Integer managerId);

    Employee createDetails(Employee employee);

    Employee getDetailsById(Long id);

    Employee updateDetails(Long id, Employee employee);

    void deleteDetails(Long id);
}
