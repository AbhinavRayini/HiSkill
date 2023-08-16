package com.hv.hiskill.service.impl;


import com.hv.hiskill.exception.ResourceNotFoundException;
import com.hv.hiskill.model.SkillSet;
import com.hv.hiskill.repository.SkillSetRepository;
import com.hv.hiskill.service.SkillEmployeeService;
import com.hv.hiskill.service.SkillSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillSetServiceImpl implements SkillSetService {

    private SkillSetRepository skillsetRepository;

    @Autowired
    public SkillSetServiceImpl(SkillSetRepository skillsetRepository) {
        this.skillsetRepository = skillsetRepository;
    }

    public SkillSet createSkillSet(SkillSet skillset) {
        return skillsetRepository.save(skillset);
    }

    public List<SkillSet> getAllSkillSets() {
        return skillsetRepository.findAll();
    }

    public SkillSet getSkillSetById(Integer id) {
        return skillsetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skillset does not exist with id: " + id));
    }

    public SkillSet updateSkillSet(Integer id, SkillSet skillSetDetails) {
        SkillSet existingSkillSet = skillsetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skillset does not exist with id: " + id));

        existingSkillSet.setSkillName(skillSetDetails.getSkillName());
        existingSkillSet.setSkillVersion(skillSetDetails.getSkillVersion());
        existingSkillSet.setCategory(skillSetDetails.getCategory());
        existingSkillSet.setSubCop(skillSetDetails.getSubCop());
        existingSkillSet.setUpdatedBy(skillSetDetails.getUpdatedBy());
        existingSkillSet.setUpdatedDate(skillSetDetails.getUpdatedDate());

        return skillsetRepository.save(existingSkillSet);
    }
}





