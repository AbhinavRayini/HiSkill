package com.hv.hiskill.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SkillSetTest {

    @Test
    void skillSetConstructorTest() {
        Integer skillId = 1;
        String skillName = "Java";
        String skillVersion = "1.8";
        String category = "Programming";
        String subCop = "Backend";
        String createdBy = "John Doe";
        LocalDate createdDate = LocalDate.now();
        String updatedBy = "Jane Smith";
        LocalDate updatedDate = LocalDate.now();
        String cop = "ABC123";

        SkillSet skillSet = new SkillSet(
                skillId, skillName, skillVersion, category, subCop,
                createdBy, createdDate, updatedBy, updatedDate, cop
        );

        assertEquals(skillId, skillSet.getSkillId());
        assertEquals(skillName, skillSet.getSkillName());
        assertEquals(skillVersion, skillSet.getSkillVersion());
        assertEquals(category, skillSet.getCategory());
        assertEquals(subCop, skillSet.getSubCop());
        assertEquals(createdBy, skillSet.getCreatedBy());
        assertEquals(createdDate, skillSet.getCreatedDate());
        assertEquals(updatedBy, skillSet.getUpdatedBy());
        assertEquals(updatedDate, skillSet.getUpdatedDate());
        assertEquals(cop, skillSet.getCop());
    }

    @Test
    void skillSetDefaultConstructorTest() {
        SkillSet skillSet = new SkillSet();

        assertNull(skillSet.getSkillId());
        assertNull(skillSet.getSkillName());
        assertNull(skillSet.getSkillVersion());
        assertNull(skillSet.getCategory());
        assertNull(skillSet.getSubCop());
        assertNull(skillSet.getCreatedBy());
        assertNull(skillSet.getCreatedDate());
        assertNull(skillSet.getUpdatedBy());
        assertNull(skillSet.getUpdatedDate());
        assertNull(skillSet.getCop());
    }

    @Test
    void skillSetToStringTest() {
        SkillSet skillSet = new SkillSet();
        skillSet.setSkillId(1);
        skillSet.setSkillName("Java");
        skillSet.setSkillVersion("1.8");
        skillSet.setCategory("Programming");
        skillSet.setSubCop("Backend");
        skillSet.setCreatedBy("John Doe");
        skillSet.setCreatedDate(LocalDate.now());
        skillSet.setUpdatedBy("Jane Smith");
        skillSet.setUpdatedDate(LocalDate.now());
        skillSet.setCop("ABC123");

        String expectedString = "skillset{" +
                "skillid=1, skillname='Java', skillversion='1.8', category='Programming', " +
                "subcop='Backend', createdby='John Doe', createddate=" + skillSet.getCreatedDate() + ", " +
                "updatedby='Jane Smith', updateddate=" + skillSet.getUpdatedDate() + ", cop='ABC123'}";

        assertEquals(expectedString, skillSet.toString());
    }
}
