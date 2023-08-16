
package com.hv.hiskill.controller;

import com.hv.hiskill.dto.EmployeeSkillDto;
import com.hv.hiskill.dto.SkillEmployeeDto2;
import com.hv.hiskill.dto.SkillEmployeeDto3;
import com.hv.hiskill.exception.ResourceNotFoundException;
import com.hv.hiskill.model.SkillEmployee;
import com.hv.hiskill.repository.SkillEmployeeRepository;
import com.hv.hiskill.service.COPLeadService;
import com.hv.hiskill.service.SkillEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SkillEmployeeControllerTest {
    @Mock
    SkillEmployeeRepository skillEmployeeRepository;

    @Mock
    private SkillEmployeeService skillEmployeeService;
    @Mock
    private COPLeadService copLeadService;
    private MockMvc mockMvc;


    @InjectMocks
    private SkillEmployeeController skillEmployeeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(skillEmployeeController).build();
    }

    @Test
    public void testGetEmployeeBySkill() {
        // Input
        String skillname = "Java"; // Replace with the skill you want to test

        // Mock the copLeadService behavior
        List<SkillEmployeeDto2> expectedList = Arrays.asList(
                new SkillEmployeeDto2("John Doe", 1),
                new SkillEmployeeDto2("Jane Smith",2)
                // Add more expected objects if needed for different test scenarios
        );
        when(copLeadService.getbyname(skillname)).thenReturn(expectedList);

        // Call the method to be tested
        List<SkillEmployeeDto2> actualList = skillEmployeeController.getEmployyeBySkill(skillname);

        // Verify the result
        assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getEmpName(), actualList.get(i).getEmpName());
            assertEquals(expectedList.get(i).getSkillId(), actualList.get(i).getSkillId());
        }

        // Verify that the copLeadService.getbyname method was called with the correct parameter
        verify(copLeadService).getbyname(skillname);
    }

    // Placeholder for the controller method implementation
    public List<SkillEmployeeDto2> getEmployyeBySkill(@PathVariable String skillname) {
        return copLeadService.getbyname(skillname);
    }

    @Test
    public void testGetAllDetails() {
        // Input
        Long len = 2L; // Replace with the desired length for testing

        // Create a list of SkillEmployeeDto3 with sample data
        List<SkillEmployeeDto3> expectedList = new ArrayList<>();
        expectedList.add(new SkillEmployeeDto3("John Doe", 1, 3));
        expectedList.add(new SkillEmployeeDto3("Jane Smith", 2, 4));

        // Mock the behavior of copLeadService.copleadserviceimpl(len)
        when(copLeadService.copleadserviceimpl(len)).thenReturn(expectedList);

        // Call the method to be tested
        List<SkillEmployeeDto3> actualList = skillEmployeeController.getAllDetails(len);

        // Verify the result
        assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getEmpName(), actualList.get(i).getEmpName());
            assertEquals(expectedList.get(i).getSkillId(), actualList.get(i).getSkillId());
            assertEquals(expectedList.get(i).getProficiencyLevel(), actualList.get(i).getProficiencyLevel());
        }

        // Verify that the copLeadService.copleadserviceimpl method was called with the correct parameter
        verify(copLeadService).copleadserviceimpl(len);
    }

    @Test
    public void testGetAllSkillemployees() {

        SkillEmployee employee1 = new SkillEmployee();
        SkillEmployee employee2 = new SkillEmployee();
        List<SkillEmployee> expectedEmployees = Arrays.asList(employee1, employee2);

        when(skillEmployeeService.getAllSkillEmployees()).thenReturn(expectedEmployees);


        List<SkillEmployee> actualEmployees = skillEmployeeController.getAllSkillemployees();


        assertEquals(expectedEmployees, actualEmployees);
        verify(skillEmployeeService, times(1)).getAllSkillEmployees();
    }

    @Test
    public void testCreateSkillemployee() {

        SkillEmployee employee = new SkillEmployee();
        SkillEmployee createdEmployee = new SkillEmployee();

        when(skillEmployeeService.createSkillEmployee(employee)).thenReturn(createdEmployee);


        SkillEmployee actualEmployee = skillEmployeeController.createSkillemployee(employee);


        assertEquals(createdEmployee, actualEmployee);
        verify(skillEmployeeService, times(1)).createSkillEmployee(employee);
    }

    @Test
    public void testGetEmployeeSkills() {

        Long empId = 1L;
        List<EmployeeSkillDto> expectedSkills = new ArrayList<>();

        when(skillEmployeeService.getEmployeeSkills(empId)).thenReturn(expectedSkills);


        List<EmployeeSkillDto> actualSkills = skillEmployeeController.getEmployeeSkills(empId);


        assertEquals(expectedSkills, actualSkills);
        verify(skillEmployeeService, times(1)).getEmployeeSkills(empId);
    }

    @Test
    public void testUpdateSkillemployee() {

        Long id = 1L;
        SkillEmployee employeeDetails = new SkillEmployee();
        SkillEmployee updatedEmployee = new SkillEmployee();

        when(skillEmployeeService.updateSkillEmployee(id, employeeDetails)).thenReturn(updatedEmployee);


        ResponseEntity<SkillEmployee> response = skillEmployeeController.updateSkillemployee(id, employeeDetails);


        assertEquals(updatedEmployee, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(skillEmployeeService, times(1)).updateSkillEmployee(id, employeeDetails);
    }

    @Test
    public void testDeleteSkillemployee() {

        Long id = 1L;


        ResponseEntity<Map<String, Boolean>> response = skillEmployeeController.deleteSkillemployee(id);


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().get("deleted"));
        verify(skillEmployeeService, times(1)).deleteSkillEmployee(id);
    }







}

