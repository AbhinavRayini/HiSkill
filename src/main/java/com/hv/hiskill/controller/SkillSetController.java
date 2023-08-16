package com.hv.hiskill.controller;

import com.hv.hiskill.model.SkillSet;
import com.hv.hiskill.service.SkillSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/skillmaster")
@Api(tags = "SkillSet API")
public class SkillSetController {

    private SkillSetService skillsetService;

    @Autowired
    public SkillSetController(SkillSetService skillsetService) {
        this.skillsetService = skillsetService;
    }

    @PostMapping
    @ApiOperation(value = "Create new details")
    public SkillSet createSkillset(@RequestBody SkillSet employee) {
        return skillsetService.createSkillSet(employee);
    }

    @GetMapping
    @ApiOperation(value = "Get all details")
    public List<SkillSet> getSkillsets() {
        return skillsetService.getAllSkillSets();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get details based on particular skillid")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public ResponseEntity<SkillSet> getSkillsetById(@PathVariable Integer id) {
        SkillSet employee = skillsetService.getSkillSetById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update the details")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved details"),
            @ApiResponse(code = 404, message = "Details not found")
    })
    public ResponseEntity<SkillSet> updateSkillset(@PathVariable Integer id, @RequestBody SkillSet employeeDetails) {
        SkillSet updatedSkillSet = skillsetService.updateSkillSet(id, employeeDetails);
        return ResponseEntity.ok(updatedSkillSet);
    }
}


