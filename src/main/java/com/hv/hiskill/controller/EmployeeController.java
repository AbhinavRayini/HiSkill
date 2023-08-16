
package com.hv.hiskill.controller;

import com.hv.hiskill.dto.EmployeeDto;
import com.hv.hiskill.model.Employee;
import com.hv.hiskill.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/employee")
@Api(tags = "Employee API")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("certificate/{certificationName}")
    @ApiOperation(value = "Get employees with a specific certification")
    public List<EmployeeDto> getCertificates(@PathVariable("certificationName") String certificationName) {
        return employeeService.getCertificates(certificationName);
    }

    @GetMapping
    @ApiOperation(value = "Get all details")
    public List<Employee> getAllDetails() {
        return employeeService.getAllDetails();
    }

    @PostMapping
    @ApiOperation(value = "Create new details")
    public ResponseEntity<Employee> createDetails(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createDetails(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get details by empID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public ResponseEntity<Employee> getDetailsById(@PathVariable Long id) {
        Employee employee = employeeService.getDetailsById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update details by empID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public ResponseEntity<Employee> updateDetails(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateDetails(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete details by empID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public ResponseEntity<Map<String, Boolean>> deleteDetails(@PathVariable Long id) {
        employeeService.deleteDetails(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
