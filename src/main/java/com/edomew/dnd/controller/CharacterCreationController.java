package com.edomew.dnd.controller;

import com.edomew.dnd.entity.Character;
import com.edomew.dnd.entity.characterField.Class;
import com.edomew.dnd.entity.characterField.Race;
import com.edomew.dnd.entity.characterField.Sex;
import com.edomew.dnd.service.impl.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/character-creation")
@SessionAttributes("userCharacter")
public class CharacterCreationController {

    private final CharacterServiceImpl characterService;


    @Autowired
    public CharacterCreationController(CharacterServiceImpl characterService) {
        this.characterService = characterService;
    }

    @ModelAttribute("userCharacter")
    public Character createCharacterModel() {
        return new Character();
    }

    @GetMapping("/create-character")
    public String showCharacterCreateForm(Model model) {
        model.addAttribute("sexes", Sex.values());
        model.addAttribute("races", Race.values());
        model.addAttribute("classes", Class.values());
        return "characterCreateForm";
    }

    @PostMapping("/loading")
    public String processCharacterCreateForm(SessionStatus status, @ModelAttribute("userCharacter") Character character) {
        Character savedCharacter = characterService.createCharacter(character);
        status.setComplete();

        return "redirect:/character-creation/" + savedCharacter;
    }

// Добавьте аналогичные методы для шагов с характеристиками, навыками и снаряжением

    @GetMapping("/{id}")
    public String showComplete(@PathVariable Long id, Model model) {
        Character character = characterService.getCharacterById(id);
        System.out.println(character.toString());
        model.addAttribute("character", character);
        return "character-complete";
    }
}
