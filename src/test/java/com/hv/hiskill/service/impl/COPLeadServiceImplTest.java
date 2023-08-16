package com.hv.hiskill.service.impl;

import com.hv.hiskill.dto.SkillEmployeeDto2;
import com.hv.hiskill.dto.SkillEmployeeDto3;
import com.hv.hiskill.dto.SkillEmployeeDto4;
import com.hv.hiskill.repository.SkillEmployeeRepository;
import com.hv.hiskill.service.impl.COPLeadServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class COPLeadServiceImplTest {
    private COPLeadServiceImpl copLeadService;

    @Mock
    private SkillEmployeeRepository skillEmployeeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        copLeadService = new COPLeadServiceImpl(skillEmployeeRepository);
    }

    @Test
    public void testCOPLeadService() {
        // Mock data
        SkillEmployeeDto3 employee1 = new SkillEmployeeDto3("John Doe", 1, 3, "Java", 1L);
        SkillEmployeeDto3 employee2 = new SkillEmployeeDto3("John Doe", 2, 2, "Python", 2L);
        List<SkillEmployeeDto3> mockEmployees = Arrays.asList(employee1, employee2);

        // Mock repository method
        when(skillEmployeeRepository.findBySkillLen()).thenReturn(mockEmployees);

        // Call the service method
        List<SkillEmployeeDto3> result = copLeadService.copleadserviceimpl(2L);

        // Assertions
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getEmpName());
        assertEquals("John Doe", result.get(1).getEmpName());
    }


@Test
public void testGetByName() {
    // Mock data
    SkillEmployeeDto2 employee1 = new SkillEmployeeDto2(1L, "John Doe", 1, 3, toDate("2022-01-01"));
    SkillEmployeeDto2 employee2 = new SkillEmployeeDto2(2L, "John Doe", 2, 2, toDate("2021-12-31"));
    List<SkillEmployeeDto2> mockEmployees = Arrays.asList(employee1, employee2);

    // ...
}
    @Test
    public void testGetByFrequency() {
        // Prepare mock data
        List<SkillEmployeeDto4> expected = new ArrayList<>();
        expected.add(new SkillEmployeeDto4(1, 10L, "Java"));
        expected.add(new SkillEmployeeDto4(2, 5L, "Python"));

        // Configure the mock repository method
        when(skillEmployeeRepository.findByCount()).thenReturn(expected);

        // Call the service method
        List<SkillEmployeeDto4> actual = copLeadService.getbyfrequency();

        // Verify the result
        assertEquals(expected, actual);
    }

    private Date toDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            // Handle the exception if necessary
            e.printStackTrace();
            return null;
        }

    }
}
