package com.hv.hiskill.service;

import com.hv.hiskill.dto.SkillEmployeeDto2;
import com.hv.hiskill.dto.SkillEmployeeDto3;
import com.hv.hiskill.dto.SkillEmployeeDto4;
import com.hv.hiskill.model.SkillEmployee;

import java.util.List;

public interface COPLeadService {
    List<SkillEmployeeDto3> copleadserviceimpl(Long len);

    List<SkillEmployeeDto2> getbyname(String skillname);


    List<SkillEmployeeDto4> getbyfrequency();
}
