package com.hv.hiskill.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



import java.util.ArrayList;
import java.util.List;



import com.hv.hiskill.exception.ManagerNotFoundException;
import com.hv.hiskill.dto.EmployeeSkillManagerDto;
import com.hv.hiskill.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public class ManagerControllerTest {



    @Mock
    private EmployeeService detailsService;



    @InjectMocks
    private ManagerController managerController;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void testGetEmployeesByManager_Success() throws ManagerNotFoundException {
        // Arrange
        int managerId = 123;
        List<EmployeeSkillManagerDto> employees = new ArrayList<>();
        employees.add(new EmployeeSkillManagerDto(101L, 111, 4,2));
        employees.add(new EmployeeSkillManagerDto(102L, 121, 3,3));
        when(detailsService.getEmployeesByManager(managerId)).thenReturn(employees);



        // Act
        ResponseEntity<?> response = managerController.getEmployeesByManager(managerId);



        // Assert
        verify(detailsService, times(1)).getEmployeesByManager(managerId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees, response.getBody());
    }



    @Test
    public void testGetEmployeesByManager_ManagerNotFound() throws ManagerNotFoundException {
        // Arrange
        int managerId = 123;
        when(detailsService.getEmployeesByManager(managerId)).thenReturn(new ArrayList<>());



        // Act
        Exception exception = assertThrows(ManagerNotFoundException.class,
                () -> managerController.getEmployeesByManager(managerId));



        // Assert
        verify(detailsService, times(1)).getEmployeesByManager(managerId);
        assertEquals("Manager not found ID:" + managerId, exception.getMessage());
    }
}