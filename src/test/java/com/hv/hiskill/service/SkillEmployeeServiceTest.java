package com.hv.hiskill.service;

import com.hv.hiskill.dto.EmployeeSkillDto;
import com.hv.hiskill.exception.ResourceNotFoundException;
import com.hv.hiskill.model.SkillEmployee;
import com.hv.hiskill.repository.SkillEmployeeRepository;
import com.hv.hiskill.service.SkillEmployeeService;
import com.hv.hiskill.service.impl.SkillEmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SkillEmployeeServiceTest {

    @Mock
    private SkillEmployeeRepository skillEmployeeRepository;

    @InjectMocks
    private SkillEmployeeServiceImpl skillEmployeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllSkillEmployees() {
        // Mock data
        SkillEmployee employee1 = new SkillEmployee();
        employee1.setId(1L);
        SkillEmployee employee2 = new SkillEmployee();
        employee2.setId(2L);
        List<SkillEmployee> employeesList = new ArrayList<>();
        employeesList.add(employee1);
        employeesList.add(employee2);

        // Mock the repository method
        when(skillEmployeeRepository.findAll()).thenReturn(employeesList);

        // Call the service method
        List<SkillEmployee> result = skillEmployeeService.getAllSkillEmployees();

        // Verify the repository method was called
        verify(skillEmployeeRepository, times(1)).findAll();

        // Verify the result
        assertEquals(employeesList, result);
    }

    @Test
    public void testCreateSkillEmployee() {
        // Mock data
        SkillEmployee employee = new SkillEmployee();
        employee.setId(1L);

        // Mock the repository method
        when(skillEmployeeRepository.save(employee)).thenReturn(employee);

        // Call the service method
        SkillEmployee result = skillEmployeeService.createSkillEmployee(employee);

        // Verify the repository method was called
        verify(skillEmployeeRepository, times(1)).save(employee);

        // Verify the result
        assertEquals(employee, result);
    }

    @Test
    public void testGetEmployeeSkills() {
        // Mock data
        Long empId = 1L;
        List<EmployeeSkillDto> employeeSkillsList = new ArrayList<>();

        // Mock the repository method
        when(skillEmployeeRepository.getEmployeeSkills(empId)).thenReturn(employeeSkillsList);

        // Call the service method
        List<EmployeeSkillDto> result = skillEmployeeService.getEmployeeSkills(empId);

        // Verify the repository method was called
        verify(skillEmployeeRepository, times(1)).getEmployeeSkills(empId);

        // Verify the result
        assertEquals(employeeSkillsList, result);
    }

    @Test
    public void testUpdateSkillEmployee() {
        // Mock data
        Long id = 1L;
        SkillEmployee existingEmployee = new SkillEmployee();
        existingEmployee.setId(id);
        existingEmployee.setProficiencyLevel(3);
        existingEmployee.setUpdatedBy("John Doe");
        existingEmployee.setUpdatedDate(LocalDate.of(2023, 6, 9));

        SkillEmployee updatedEmployee = new SkillEmployee();
        updatedEmployee.setId(id);
        updatedEmployee.setProficiencyLevel(5);
        updatedEmployee.setUpdatedBy("Jane Smith");
        updatedEmployee.setUpdatedDate(LocalDate.of(2023, 6, 9));

        // Mock the repository method
        when(skillEmployeeRepository.findById(id)).thenReturn(Optional.of(existingEmployee));
        when(skillEmployeeRepository.save(existingEmployee)).thenReturn(updatedEmployee);

        // Call the service method
        SkillEmployee result = skillEmployeeService.updateSkillEmployee(id, updatedEmployee);

        // Verify the repository method was called
        verify(skillEmployeeRepository, times(1)).findById(id);
        verify(skillEmployeeRepository, times(1)).save(existingEmployee);

        // Verify the result
        assertEquals(updatedEmployee, result);
        assertEquals(updatedEmployee.getProficiencyLevel(), result.getProficiencyLevel());
        assertEquals(updatedEmployee.getUpdatedBy(), result.getUpdatedBy());
        assertEquals(updatedEmployee.getUpdatedDate(), result.getUpdatedDate());
    }

    @Test
    public void testDeleteSkillEmployee() {
        // Mock data
        Long id = 1L;
        SkillEmployee employee = new SkillEmployee();
        employee.setId(id);

        // Mock the repository method
        when(skillEmployeeRepository.findById(id)).thenReturn(Optional.of(employee));

        // Call the service method
        skillEmployeeService.deleteSkillEmployee(id);

        // Verify the repository method was called
        verify(skillEmployeeRepository, times(1)).findById(id);
        verify(skillEmployeeRepository, times(1)).delete(employee);
    }

    @Test
    public void testUpdateSkillEmployee_ResourceNotFoundException() {
        // Mock data
        Long id = 1L;
        SkillEmployee updatedEmployee = new SkillEmployee();
        updatedEmployee.setId(id);

        // Mock the repository method
        when(skillEmployeeRepository.findById(id)).thenReturn(Optional.empty());

        // Call the service method and assert that it throws ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> skillEmployeeService.updateSkillEmployee(id, updatedEmployee));

        // Verify the repository method was called
        verify(skillEmployeeRepository, times(1)).findById(id);
        verify(skillEmployeeRepository, times(0)).save(any());
    }

    @Test
    public void testDeleteSkillEmployee_ResourceNotFoundException() {
        // Mock data
        Long id = 1L;

        // Mock the repository method
        when(skillEmployeeRepository.findById(id)).thenReturn(Optional.empty());

        // Call the service method and assert that it throws ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> skillEmployeeService.deleteSkillEmployee(id));

        // Verify the repository method was called
        verify(skillEmployeeRepository, times(1)).findById(id);
        verify(skillEmployeeRepository, times(0)).delete(any());
    }
}
