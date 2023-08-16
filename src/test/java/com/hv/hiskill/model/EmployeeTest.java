package com.hv.hiskill.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeTest {
    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee();
    }

    @Test
    public void testSetAndGetEmpId() {
        Long empId = 1L;
        employee.setEmpId(empId);
        Assertions.assertEquals(empId, employee.getEmpId());
    }

    @Test
    public void testSetAndGetEmpName() {
        String empName = "John Doe";
        employee.setEmpName(empName);
        Assertions.assertEquals(empName, employee.getEmpName());
    }

    // Add more test methods for other properties and behaviors of the Employee class

    @Test
    public void testToString() {
        String expectedString = "Employee{empId=1, empName='John Doe', cop='COP', subCop='Sub COP', jobTitle='Job Title', role='Role', managerId=1, createdBy='Created By', createdDate=2023-01-01, updatedBy='Updated By', updatedDate=2023-01-01, skill=null, SkillEmployees=null, certificationsList=null, email='test@example.com', password='password', roles=[]}";
        employee.setEmpId(1L);
        employee.setEmpName("John Doe");
        employee.setCop("COP");
        employee.setSubCop("Sub COP");
        employee.setJobTitle("Job Title");
        employee.setRole("Role");
        employee.setManagerId(1);
        employee.setCreatedBy("Created By");
        employee.setCreatedDate(LocalDate.of(2023, 1, 1));
        employee.setUpdatedBy("Updated By");
        employee.setUpdatedDate(LocalDate.of(2023, 1, 1));
        employee.setEmail("test@example.com");
        employee.setPassword("password");
        employee.setRoles(new HashSet<>());

        Assertions.assertEquals(expectedString, employee.toString());
    }
}




//import org.junit.jupiter.api.Test;
//
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class EmployeeTest {
//
//    @Test
//    public void testToString() {
//
//        Employee employee = new Employee();
//        employee.setEmpId(1L);
//        employee.setEmpName("John Doe");
//        employee.setCop("COP");
//        employee.setSubCop("Sub COP");
//        employee.setJobTitle("Job Title");
//        employee.setRole("Role");
//        employee.setManagerId(456);
//        employee.setCreatedBy("Creator");
//        employee.setCreatedDate(LocalDate.now());
//        employee.setUpdatedBy("Updater");
//        employee.setUpdatedDate(LocalDate.now());
//
//
//        String expectedString = "Details{" +
//                "empId=1, " +
//                "empName='John Doe', " +
//                "cop='COP', " +
//                "subcop='Sub COP', " +
//                "jobtitle='Job Title', " +
//                "role='Role', " +
//                "managerid=456, " +
//                "createdby='Creator', " +
//                "createddate=" + employee.getCreatedDate() + ", " +
//                "updatedby='Updater', " +
//                "updateddate=" + employee.getUpdatedDate() +
//                "}";
//
//
//        String actualString = employee.toString();
//
//
//        assertEquals(expectedString, actualString);
//    }
//}