package com.hv.hiskill.service.impl;

import com.hv.hiskill.dto.SkillEmployeeDto2;
import com.hv.hiskill.dto.SkillEmployeeDto3;

import com.hv.hiskill.dto.SkillEmployeeDto4;
import com.hv.hiskill.repository.SkillEmployeeRepository;
import com.hv.hiskill.service.COPLeadService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





@Service
public class COPLeadServiceImpl implements COPLeadService {
    @Autowired
    private SkillEmployeeRepository skillEmployeeRepository;



    private List<SkillEmployeeDto3> employees = new ArrayList<>();
     public Comparator<SkillEmployeeDto3> empSkillComparator = new Comparator<SkillEmployeeDto3>() {


@Override

public int compare(SkillEmployeeDto3 s1, SkillEmployeeDto3 s2) {
Integer proficiencyLevel1 = s1.getProficiencyLevel();
    Integer proficiencyLevel2 = s2.getProficiencyLevel();


    if (proficiencyLevel1 == null && proficiencyLevel2 == null) {
        return 0;
    } else if (proficiencyLevel1 == null) {
        return -1;
    } else if (proficiencyLevel2 == null) {
        return 1;
    }

    // Compare proficiency levels in ascending order
    return Integer.compare(proficiencyLevel1, proficiencyLevel2);
}
    };

    public COPLeadServiceImpl(SkillEmployeeRepository skillEmployeeRepository) {
        this.skillEmployeeRepository = skillEmployeeRepository;
    }


    public List<SkillEmployeeDto3> copleadserviceimpl(Long len) {

        List<SkillEmployeeDto3> employees=skillEmployeeRepository.findBySkillLen();

        Collections.sort(employees,empSkillComparator);

        return employees.subList(0, Math.min(employees.size(), len.intValue()));
    }

    public List<SkillEmployeeDto2> getbyname(String skillname) {
        return skillEmployeeRepository.findBySkillName(skillname);
    }

    @Override
    public List<SkillEmployeeDto4> getbyfrequency() {
        return skillEmployeeRepository.findByCount();
    }

}






