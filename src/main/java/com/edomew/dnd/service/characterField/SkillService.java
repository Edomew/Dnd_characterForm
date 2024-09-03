package com.edomew.dnd.service.characterField;

import com.edomew.dnd.entity.characterField.Skill;

import java.util.List;

public interface SkillService {
    Skill createSkill(Skill skill);
    Skill updateSkill(Skill skill);
    void deleteSkill(Long skillId);
    Skill getSkillById(Long skillId);
    List<Skill> getAllSkills();
}
