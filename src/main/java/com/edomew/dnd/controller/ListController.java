package com.edomew.dnd.controller;

import com.edomew.dnd.entity.Character;
import com.edomew.dnd.entity.characterField.Skill;
import com.edomew.dnd.service.characterField.impl.SkillServiceImpl;
import com.edomew.dnd.service.impl.CharacterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/list")
public class ListController {
    private final CharacterServiceImpl characterService;
    private final SkillServiceImpl skillService;

    public ListController(CharacterServiceImpl characterService, SkillServiceImpl skillService) {
        this.characterService = characterService;
        this.skillService = skillService;
    }

    @PostMapping("/addSkill")
    public void addSkill(Long characterId){
        Character character = characterService.getCharacterById(characterId);
        Skill skill = new Skill();
        skill.setCharacter(character);
        skillService.createSkill(skill);
        character.getCharacterSkills().add(skill);
        characterService.updateCharacter(character);
    }

    @PostMapping("/removeSkill")
    public void removeSkill(Long skillId){
        skillService.deleteSkill(skillId);
    }

}
