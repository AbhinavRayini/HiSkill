
package com.hv.hiskill.controller;

import com.hv.hiskill.model.SkillSet;
import com.hv.hiskill.service.SkillSetService;
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
import static org.mockito.Mockito.*;

class SkillSetControllerTest {

    @Mock
    private SkillSetService skillsetService;

    @InjectMocks
    private SkillSetController skillsetController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createSkillsetTest() {
        SkillSet employee = new SkillSet();
        when(skillsetService.createSkillSet(employee)).thenReturn(employee);

        SkillSet createdSkillSet = skillsetController.createSkillset(employee);

        assertEquals(employee, createdSkillSet);
        verify(skillsetService, times(1)).createSkillSet(employee);
    }

    @Test
    void getSkillsetsTest() {
        List<SkillSet> SkillSets = new ArrayList<>();
        when(skillsetService.getAllSkillSets()).thenReturn(SkillSets);

        List<SkillSet> retrievedSkillSets = skillsetController.getSkillsets();

        assertEquals(SkillSets, retrievedSkillSets);
        verify(skillsetService, times(1)).getAllSkillSets();
    }

    @Test
    void getSkillsetByIdTest() {
        SkillSet employee = new SkillSet();
        int skillsetId = 1;
        when(skillsetService.getSkillSetById(skillsetId)).thenReturn(employee);

        ResponseEntity<SkillSet> responseEntity = skillsetController.getSkillsetById(skillsetId);
        HttpStatus statusCode = responseEntity.getStatusCode();
        SkillSet retrievedSkillSet = responseEntity.getBody();

        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(employee, retrievedSkillSet);
        verify(skillsetService, times(1)).getSkillSetById(skillsetId);
    }

    @Test
    void updateSkillsetTest() {
        SkillSet employee = new SkillSet();
        int skillsetId = 1;
        SkillSet employeeDetails = new SkillSet();

        when(skillsetService.updateSkillSet(skillsetId, employeeDetails)).thenReturn(employee);

        ResponseEntity<SkillSet> responseEntity = skillsetController.updateSkillset(skillsetId, employeeDetails);
        HttpStatus statusCode = responseEntity.getStatusCode();
        SkillSet updatedSkillSet = responseEntity.getBody();

        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(employee, updatedSkillSet);
        verify(skillsetService, times(1)).updateSkillSet(skillsetId, employeeDetails);
    }
}
