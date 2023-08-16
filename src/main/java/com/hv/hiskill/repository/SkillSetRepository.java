package com.hv.hiskill.repository;

import com.hv.hiskill.model.SkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillSetRepository extends JpaRepository<SkillSet,Integer> {

}
