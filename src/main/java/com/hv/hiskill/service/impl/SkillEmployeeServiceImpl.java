package com.hv.hiskill.service.impl;

import com.hv.hiskill.dto.EmployeeSkillDto;
import com.hv.hiskill.exception.ResourceNotFoundException;
import com.hv.hiskill.model.SkillEmployee;
import com.hv.hiskill.repository.SkillEmployeeRepository;
import com.hv.hiskill.service.SkillEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;





@Service
public class SkillEmployeeServiceImpl implements SkillEmployeeService {

    private SkillEmployeeRepository skillemployeeRepository;

    @Autowired
    public SkillEmployeeServiceImpl(SkillEmployeeRepository skillemployeeRepository) {
        this.skillemployeeRepository = skillemployeeRepository;
    }

    public List<SkillEmployee> getAllSkillEmployees() {
        return skillemployeeRepository.findAll();
    }

    public SkillEmployee createSkillEmployee(SkillEmployee employee) {
        return skillemployeeRepository.save(employee);
    }

    public List<EmployeeSkillDto> getEmployeeSkills(Long empId) {
        return skillemployeeRepository.getEmployeeSkills(empId);
    }

    public SkillEmployee updateSkillEmployee(Long id, SkillEmployee employeeDetails) {
        SkillEmployee employee = skillemployeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
        employee.setProficiencyLevel(employeeDetails.getProficiencyLevel());
        employee.setUpdatedBy(employeeDetails.getUpdatedBy());
        employee.setUpdatedDate(employeeDetails.getUpdatedDate());
        return skillemployeeRepository.save(employee);
    }

    public void deleteSkillEmployee(Long id) {
        SkillEmployee employee = skillemployeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
        skillemployeeRepository.delete(employee);
    }
}

