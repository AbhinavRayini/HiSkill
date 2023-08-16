package com.hv.hiskill.service;


import com.hv.hiskill.model.SkillSet;

import java.util.List;

public interface SkillSetService {
    SkillSet createSkillSet(SkillSet skillSet);

    List<SkillSet> getAllSkillSets();

    SkillSet getSkillSetById(Integer id);

    SkillSet updateSkillSet(Integer id, SkillSet skillSetDetails);
}

