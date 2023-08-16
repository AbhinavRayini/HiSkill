package com.hv.hiskill.service.impl;

import com.hv.hiskill.dto.EmployeeDto;
import com.hv.hiskill.dto.EmployeeSkillManagerDto;
import com.hv.hiskill.exception.ResourceNotFoundException;
import com.hv.hiskill.model.Employee;
import com.hv.hiskill.repository.EmployeeRepository;
import com.hv.hiskill.repository.ManagerRepository;
import com.hv.hiskill.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    private ManagerRepository managerRepository;

    public List<EmployeeSkillManagerDto> getEmployeesByManager(Integer managerId) {
        List<EmployeeSkillManagerDto> dto = managerRepository.getEmployeesByManager(managerId);
        return dto;
    }

    public List<EmployeeDto> getCertificates(String certificationName) {
        return employeeRepository.getCertificates(certificationName);
    }

    public List<Employee> getAllDetails() {
        return employeeRepository.findAll();
    }

    public Employee createDetails(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getDetailsById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Details not exist with id :" + id));
    }

    public Employee updateDetails(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        existingEmployee.setEmpName(employee.getEmpName());
        existingEmployee.setCop(employee.getCop());
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setUpdatedBy(employee.getUpdatedBy());
        existingEmployee.setUpdatedDate(employee.getUpdatedDate());
        existingEmployee.setJobTitle(employee.getJobTitle());
        existingEmployee.setManagerId(employee.getManagerId());
        existingEmployee.setSubCop(employee.getSubCop());
        existingEmployee.setPassword(employee.getPassword());
        existingEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(existingEmployee);
    }

    public void deleteDetails(Long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        employeeRepository.delete(existingEmployee);
    }
}

