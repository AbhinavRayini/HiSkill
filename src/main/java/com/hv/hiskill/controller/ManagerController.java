package com.hv.hiskill.controller;

import com.hv.hiskill.repository.ManagerRepository;
import com.hv.hiskill.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.hv.hiskill.dto.EmployeeSkillManagerDto;
import com.hv.hiskill.exception.ManagerNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
@Api(tags = "Manager API")
public class ManagerController {

    @Autowired
    private EmployeeService detailsService;

    @GetMapping("/{managerId}")
    @ApiOperation(value = "Get employees under a particular Manager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details of employees under particular ManagerID "),
            @ApiResponse(code = 404, message = "ManagerID Not Found")
    })
    public ResponseEntity<?> getEmployeesByManager(@PathVariable Integer managerId) {
        List<EmployeeSkillManagerDto> employees = detailsService.getEmployeesByManager(managerId);
        if (employees.isEmpty()) {
            throw new ManagerNotFoundException("Manager not found ID:" + managerId);
        }
        return ResponseEntity.ok(employees);
    }

}
