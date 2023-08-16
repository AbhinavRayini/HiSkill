package com.hv.hiskill.controller;

import com.hv.hiskill.dto.EmployeeSkillDto;
import com.hv.hiskill.dto.SkillEmployeeDto2;
import com.hv.hiskill.dto.SkillEmployeeDto3;
import com.hv.hiskill.dto.SkillEmployeeDto4;
import com.hv.hiskill.model.SkillEmployee;
import com.hv.hiskill.service.COPLeadService;
import com.hv.hiskill.service.SkillEmployeeService;
import com.hv.hiskill.service.impl.COPLeadServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/skillemp")
@Api(tags = "SkillEmployee API")
public class SkillEmployeeController {

    private SkillEmployeeService skillemployeeService;
     @Autowired
    private COPLeadService copLeadService;

    @Autowired
    public SkillEmployeeController(SkillEmployeeService skillemployeeService) {
        this.skillemployeeService = skillemployeeService;
    }

    @GetMapping
    @ApiOperation(value = "Get all details")
    public List<SkillEmployee> getAllSkillemployees() {
        return skillemployeeService.getAllSkillEmployees();
    }

    @PostMapping
    @ApiOperation(value = "Create new details")
    public SkillEmployee createSkillemployee(@RequestBody SkillEmployee employee) {
        return skillemployeeService.createSkillEmployee(employee);
    }

    @GetMapping("/{empId}")
    @ApiOperation(value = "Get details based on empid")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public List<EmployeeSkillDto> getEmployeeSkills(@PathVariable Long empId) {
        return skillemployeeService.getEmployeeSkills(empId);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update the deatils by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public ResponseEntity<SkillEmployee> updateSkillemployee(@PathVariable Long id, @RequestBody SkillEmployee employeeDetails) {
        SkillEmployee updatedSkillEmployee = skillemployeeService.updateSkillEmployee(id, employeeDetails);
        return ResponseEntity.ok(updatedSkillEmployee);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the deatils by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public ResponseEntity<Map<String, Boolean>> deleteSkillemployee(@PathVariable Long id) {
        skillemployeeService.deleteSkillEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/skill/{len}")

    @ApiOperation(value = "it gets the list of details with profiency level based on the given count")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    //public List<SkillEmployee> getAllDetails(@PathVariable Long len) {return copLeadService.copleadserviceimpl(len);
    public List<SkillEmployeeDto3> getAllDetails(@PathVariable Long len) {return copLeadService.copleadserviceimpl(len);

}


    @GetMapping("EmpSkill/{skillname}")

    @ApiOperation(value = "it gets the details based on skillid")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public List<SkillEmployeeDto2> getEmployyeBySkill(@PathVariable String skillname) {
        return copLeadService.getbyname(skillname);
    }
    @GetMapping("EmpSkill/count")
    @ApiOperation(value="it gets the count of employees with skillname")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public List<SkillEmployeeDto4> getEmployeeByCount(){
        return copLeadService.getbyfrequency();
    }
}











