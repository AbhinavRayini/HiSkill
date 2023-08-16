
package com.hv.hiskill.controller;

import com.hv.hiskill.dto.EmployeeDto;
import com.hv.hiskill.model.Employee;
import com.hv.hiskill.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCertificates_ReturnsListOfCertificates() {

        String certificationName = "Some Certification";
        List<EmployeeDto> certificates = new ArrayList<>();


        when(employeeService.getCertificates(anyString())).thenReturn(certificates);


        List<EmployeeDto> result = employeeController.getCertificates(certificationName);


        assertEquals(certificates, result);
        verify(employeeService).getCertificates(certificationName);
    }

    @Test
    void getAllDetails_ReturnsListOfDetails() {

        List<Employee> employeeList = new ArrayList<>();


        when(employeeService.getAllDetails()).thenReturn(employeeList);


        List<Employee> result = employeeController.getAllDetails();


        assertEquals(employeeList, result);
        verify(employeeService).getAllDetails();
    }

    @Test
    void createDetails_ReturnsCreatedDetailsWithHttpStatusCreated() {

        Employee employee = new Employee();


        when(employeeService.createDetails(any(Employee.class))).thenReturn(employee);


        ResponseEntity<Employee> responseEntity = employeeController.createDetails(employee);


        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
        verify(employeeService).createDetails(employee);
    }

    @Test
    void getDetailsById_ReturnsDetailsWithHttpStatusOk() {

        Long id = 1L;
        Employee employee = new Employee();


        when(employeeService.getDetailsById(anyLong())).thenReturn(employee);


        ResponseEntity<Employee> responseEntity = employeeController.getDetailsById(id);


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
        verify(employeeService).getDetailsById(id);
    }

    @Test
    void updateDetails_ReturnsUpdatedDetailsWithHttpStatusOk() {

        Long id = 1L;
        Employee employee = new Employee();


        when(employeeService.updateDetails(anyLong(), any(Employee.class))).thenReturn(employee);


        ResponseEntity<Employee> responseEntity = employeeController.updateDetails(id, employee);


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
        verify(employeeService).updateDetails(id, employee);
    }

}
