package com.hv.hiskill.service;

import com.hv.hiskill.dto.EmployeeDto;
import com.hv.hiskill.dto.EmployeeSkillManagerDto;
import com.hv.hiskill.exception.ResourceNotFoundException;
import com.hv.hiskill.model.Employee;
import com.hv.hiskill.repository.EmployeeRepository;
import com.hv.hiskill.repository.ManagerRepository;
import com.hv.hiskill.service.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ManagerRepository managerRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetEmployeesByManager() {
        int managerId = 123;


        List<EmployeeSkillManagerDto> mockDtoList = new ArrayList<>();


        when(managerRepository.getEmployeesByManager(managerId)).thenReturn(mockDtoList);


    }

    @Test
    public void testGetCertificates() {
        String certificationName = "Java";


        List<EmployeeDto> mockDtoList = new ArrayList<>();

        when(employeeRepository.getCertificates(certificationName)).thenReturn(mockDtoList);


        List<EmployeeDto> result = employeeService.getCertificates(certificationName);


        verify(employeeRepository, times(1)).getCertificates(certificationName);


        Assert.assertEquals(mockDtoList, result);
    }

    @Test
    public void testGetAllDetails() {

        List<Employee> mockEmployeeList = new ArrayList<>();

        when(employeeRepository.findAll()).thenReturn(mockEmployeeList);


        List<Employee> result = employeeService.getAllDetails();


        verify(employeeRepository, times(1)).findAll();


        Assert.assertEquals(mockEmployeeList, result);
    }

    @Test
    public void testCreateDetails() {
        Employee mockEmployee = new Employee();


        when(employeeRepository.save(any(Employee.class))).thenReturn(mockEmployee);


        Employee result = employeeService.createDetails(mockEmployee);


        verify(employeeRepository, times(1)).save(mockEmployee);


        Assert.assertEquals(mockEmployee, result);
    }

    @Test
    public void testGetDetailsById() {
        Long id = 123L;
        Employee mockEmployee = new Employee();


        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockEmployee));


        Employee result = employeeService.getDetailsById(id);


        verify(employeeRepository, times(1)).findById(id);


        Assert.assertEquals(mockEmployee, result);
    }

    @Test
    public void testUpdateDetails() {
        Long id = 123L;
        Employee mockEmployee = new Employee();
        Employee updatedEmployee = new Employee();
        updatedEmployee.setEmpId(id);


        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockEmployee));


        when(employeeRepository.save(any(Employee.class))).thenReturn(updatedEmployee);


        Employee result = employeeService.updateDetails(id, mockEmployee);


        verify(employeeRepository, times(1)).findById(id);


        verify(employeeRepository, times(1)).save(mockEmployee);


        Assert.assertEquals(updatedEmployee, result);
    }

    @Test
    public void testDeleteDetails() {
        Long id = 123L;
        Employee mockEmployee = new Employee();


        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockEmployee));


        employeeService.deleteDetails(id);


        verify(employeeRepository, times(1)).findById(id);


        verify(employeeRepository, times(1)).delete(mockEmployee);
    }
}
