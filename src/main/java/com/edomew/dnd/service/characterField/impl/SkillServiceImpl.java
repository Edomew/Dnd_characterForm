package com.edomew.dnd.service.characterField.impl;

import com.edomew.dnd.entity.characterField.Skill;
import com.edomew.dnd.repository.SkillRepository;
import com.edomew.dnd.service.characterField.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill updateSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long skillId) {
skillRepository.deleteById(skillId);
    }

    @Override
    public Skill getSkillById(Long skillId) {

        return skillRepository.findById(skillId).isPresent()
                ?
                skillRepository.findById(skillId).get()
                :
                null;
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // Реализация методов интерфейса
}
