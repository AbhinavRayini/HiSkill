package com.hv.hiskill.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

class SkillEmployeeTest {
    @Test
    public void testGettersAndSetters() {

        SkillEmployee employee = new SkillEmployee();


        employee.setId(1L);
        employee.setSkillId(123);
        employee.setEmpId(1001L);
        employee.setProficiencyLevel(5);
       employee.setLastUsed(new Date());
        employee.setCreatedBy("John Doe");
        employee.setCreatedDate(LocalDate.now());
        employee.setUpdatedBy("Jane Smith");
        employee.setUpdatedDate(LocalDate.now());
        employee.setYearsOfExperience(3);

        Assertions.assertEquals(1L, employee.getId());
        Assertions.assertEquals(123, employee.getSkillId());
        Assertions.assertEquals(1001L, employee.getEmpId());
        Assertions.assertEquals(5, employee.getProficiencyLevel());
        Assertions.assertNotNull(employee.getLastUsed());
        Assertions.assertEquals("John Doe", employee.getCreatedBy());
        Assertions.assertNotNull(employee.getCreatedDate());
        Assertions.assertEquals("Jane Smith", employee.getUpdatedBy());
        Assertions.assertNotNull(employee.getUpdatedDate());
        Assertions.assertEquals(3, employee.getYearsOfExperience());
    }





    @Test
    public void testToString() {
        SkillEmployee employee = new SkillEmployee();
        String toStringResult = employee.toString();

        Assertions.assertTrue(toStringResult.contains("id="));
        Assertions.assertTrue(toStringResult.contains("skillId="));
        Assertions.assertTrue(toStringResult.contains("empId="));
        Assertions.assertTrue(toStringResult.contains("proficiencyLevel="));
        Assertions.assertTrue(toStringResult.contains("lastUsed="));
        Assertions.assertTrue(toStringResult.contains("createdBy="));
        Assertions.assertTrue(toStringResult.contains("createdDate="));
        Assertions.assertTrue(toStringResult.contains("updatedBy="));
        Assertions.assertTrue(toStringResult.contains("updatedDate="));
        Assertions.assertTrue(toStringResult.contains("yearsOfExperience="));
    }
}