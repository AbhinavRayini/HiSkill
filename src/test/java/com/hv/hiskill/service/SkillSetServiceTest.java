package com.hv.hiskill.service;
//import com.hv.hiskill.exception.ResourceNotFoundException;
//import com.hv.hiskill.model.SkillSet;
//import com.hv.hiskill.repository.SkillSetRepository;
//import com.hv.hiskill.service.impl.SkillSetServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class SkillSetServiceTest {
//
//    @Mock
//    private SkillSetRepository skillSetRepository;
//
//    @InjectMocks
//    private SkillSetServiceImpl skillSetService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void createSkillSetTest() {
//        SkillSet skillSet = new SkillSet();
//        skillSet.setSkillId(1);
//        skillSet.setSkillName("Java");
//        skillSet.setSkillVersion("1.8");
//
//        when(skillSetRepository.save(skillSet)).thenReturn(skillSet);
//
//        SkillSet createdSkillSet = skillSetService.createSkillSet(skillSet);
//
//        assertNotNull(createdSkillSet);
//        assertEquals(skillSet.getSkillId(), createdSkillSet.getSkillId());
//        assertEquals(skillSet.getSkillName(), createdSkillSet.getSkillName());
//        assertEquals(skillSet.getSkillVersion(), createdSkillSet.getSkillVersion());
//
//        verify(skillSetRepository, times(1)).save(skillSet);
//    }
//
//    @Test
//    void getAllSkillSetsTest() {
//        SkillSet skillSet1 = new SkillSet(1, "Java", "1.8");
//        SkillSet skillSet2 = new SkillSet(2, "Python", "3.9");
//        List<SkillSet> skillSets = Arrays.asList(skillSet1, skillSet2);
//
//        when(skillSetRepository.findAll()).thenReturn(skillSets);
//
//        List<SkillSet> retrievedSkillSets = skillSetService.getAllSkillSets();
//
//        assertNotNull(retrievedSkillSets);
//        assertEquals(skillSets.size(), retrievedSkillSets.size());
//        assertEquals(skillSets.get(0).getSkillId(), retrievedSkillSets.get(0).getSkillId());
//        assertEquals(skillSets.get(0).getSkillName(), retrievedSkillSets.get(0).getSkillName());
//        assertEquals(skillSets.get(0).getSkillVersion(), retrievedSkillSets.get(0).getSkillVersion());
//        assertEquals(skillSets.get(1).getSkillId(), retrievedSkillSets.get(1).getSkillId());
//        assertEquals(skillSets.get(1).getSkillName(), retrievedSkillSets.get(1).getSkillName());
//        assertEquals(skillSets.get(1).getSkillVersion(), retrievedSkillSets.get(1).getSkillVersion());
//
//        verify(skillSetRepository, times(1)).findAll();
//    }
//
//    @Test
//    void getSkillSetByIdExistingIdTest() {
//        SkillSet skillSet = new SkillSet(1, "Java", "1.8");
//
//        when(skillSetRepository.findById(1)).thenReturn(Optional.of(skillSet));
//
//        SkillSet retrievedSkillSet = skillSetService.getSkillSetById(1);
//
//        assertNotNull(retrievedSkillSet);
//        assertEquals(skillSet.getSkillId(), retrievedSkillSet.getSkillId());
//        assertEquals(skillSet.getSkillName(), retrievedSkillSet.getSkillName());
//        assertEquals(skillSet.getSkillVersion(), retrievedSkillSet.getSkillVersion());
//
//        verify(skillSetRepository, times(1)).findById(1);
//    }
//
//    @Test
//    void getSkillSetByIdNonExistingIdTest() {
//        when(skillSetRepository.findById(1)).thenReturn(Optional.empty());
//
//        assertThrows(ResourceNotFoundException.class, () -> {
//            skillSetService.getSkillSetById(1);
//        });
//
//        verify(skillSetRepository, times(1)).findById(1);
//    }
//
//    @Test
//    void updateSkillSetExistingIdTest() {
//        SkillSet existingSkillSet = new SkillSet(1, "Java", "1.8");
//        SkillSet updatedSkillSet = new SkillSet(1, "Python", "3.9");
//
//        when(skillSetRepository.findById(1)).thenReturn(Optional.of(existingSkillSet));
//        when(skillSetRepository.save(existingSkillSet)).thenReturn(updatedSkillSet);
//
//        SkillSet resultSkillSet = skillSetService.updateSkillSet(1, updatedSkillSet);
//
//        assertNotNull(resultSkillSet);
//        assertEquals(updatedSkillSet.getSkillId(), resultSkillSet.getSkillId());
//        assertEquals(updatedSkillSet.getSkillName(), resultSkillSet.getSkillName());
//        assertEquals(updatedSkillSet.getSkillVersion(), resultSkillSet.getSkillVersion());
//
//        verify(skillSetRepository, times(1)).findById(1);
//        verify(skillSetRepository, times(1)).save(existingSkillSet);
//    }
//
//    @Test
//    void updateSkillSetNonExistingIdTest() {
//        SkillSet updatedSkillSet = new SkillSet(1, "Python", "3.9");
//
//        when(skillSetRepository.findById(1)).thenReturn(Optional.empty());
//
//        assertThrows(ResourceNotFoundException.class, () -> {
//            skillSetService.updateSkillSet(1, updatedSkillSet);
//        });
//
//        verify(skillSetRepository, times(1)).findById(1);
//        verify(skillSetRepository, never()).save(any(SkillSet.class));
//    }
//}

import com.hv.hiskill.exception.ResourceNotFoundException;
import com.hv.hiskill.model.SkillSet;
import com.hv.hiskill.repository.SkillSetRepository;
import com.hv.hiskill.service.impl.SkillSetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SkillSetServiceTest {

    private SkillSetServiceImpl skillSetService;

    @Mock
    private SkillSetRepository skillSetRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        skillSetService = new SkillSetServiceImpl(skillSetRepository);
    }

    @Test
    void testCreateSkillSet() {
        // Prepare test data
        SkillSet skillSet = new SkillSet();
        skillSet.setSkillId(1);
        skillSet.setSkillName("Java");

        // Mock repository response
        when(skillSetRepository.save(skillSet)).thenReturn(skillSet);

        // Call the method under test
        SkillSet result = skillSetService.createSkillSet(skillSet);

        // Verify repository method was called
        verify(skillSetRepository, times(1)).save(skillSet);

        // Verify the expected result
        assertNotNull(result);
        assertEquals(skillSet.getSkillId(), result.getSkillId());
        assertEquals(skillSet.getSkillName(), result.getSkillName());
    }

    @Test
    void testGetAllSkillSets() {
        // Prepare test data
        List<SkillSet> skillSetList = Arrays.asList(
                new SkillSet(1, "Java", "1.8", "Programming", "COP1", "John", null, "Alice", null, "COP1"),
                new SkillSet(2, "Python", "3.9", "Programming", "COP2", "Bob", null, "Charlie", null, "COP2")
        );

        // Mock repository response
        when(skillSetRepository.findAll()).thenReturn(skillSetList);

        // Call the method under test
        List<SkillSet> result = skillSetService.getAllSkillSets();

        // Verify repository method was called
        verify(skillSetRepository, times(1)).findAll();

        // Verify the expected result
        assertEquals(2, result.size());
        assertEquals(skillSetList, result);
    }

    @Test
    void testGetSkillSetById() {
        // Prepare test data
        SkillSet skillSet = new SkillSet(1, "Java", "1.8", "Programming", "COP1", "John", null, "Alice", null, "COP1");

        // Mock repository response
        when(skillSetRepository.findById(1)).thenReturn(Optional.of(skillSet));

        // Call the method under test
        SkillSet result = skillSetService.getSkillSetById(1);

        // Verify repository method was called
        verify(skillSetRepository, times(1)).findById(1);

        // Verify the expected result
        assertNotNull(result);
        assertEquals(skillSet, result);
    }

    @Test
    void testGetSkillSetById_NotFound() {
        // Mock repository response
        when(skillSetRepository.findById(1)).thenReturn(Optional.empty());

        // Call the method under test and verify exception is thrown
        assertThrows(ResourceNotFoundException.class, () -> skillSetService.getSkillSetById(1));

        // Verify repository method was called
        verify(skillSetRepository, times(1)).findById(1);
    }

    @Test
    void testUpdateSkillSet() {
        // Prepare test data
        SkillSet existingSkillSet = new SkillSet(1, "Java", "1.8", "Programming", "COP1", "John", null, "Alice", null, "COP1");
        SkillSet updatedSkillSetDetails = new SkillSet();
        updatedSkillSetDetails.setSkillName("Python");

        // Mock repository response
        when(skillSetRepository.findById(1)).thenReturn(Optional.of(existingSkillSet));
        when(skillSetRepository.save(existingSkillSet)).thenReturn(existingSkillSet);

        // Call the method under test
        SkillSet result = skillSetService.updateSkillSet(1, updatedSkillSetDetails);

        // Verify repository method was called
        verify(skillSetRepository, times(1)).findById(1);
        verify(skillSetRepository, times(1)).save(existingSkillSet);

        // Verify the expected result
        assertNotNull(result);
        assertEquals(updatedSkillSetDetails.getSkillName(), result.getSkillName());
    }

    @Test
    void testUpdateSkillSet_NotFound() {
        // Prepare test data
        SkillSet updatedSkillSetDetails = new SkillSet();
        updatedSkillSetDetails.setSkillName("Python");

        // Mock repository response
        when(skillSetRepository.findById(1)).thenReturn(Optional.empty());

        // Call the method under test and verify exception is thrown
        assertThrows(ResourceNotFoundException.class, () -> skillSetService.updateSkillSet(1, updatedSkillSetDetails));

        // Verify repository method was called
        verify(skillSetRepository, times(1)).findById(1);
        verify(skillSetRepository, times(0)).save(any());
    }
}
