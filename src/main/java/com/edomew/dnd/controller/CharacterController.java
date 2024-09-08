package com.edomew.dnd.controller;

import com.edomew.dnd.entity.Character;
import com.edomew.dnd.entity.characterField.Class;
import com.edomew.dnd.entity.characterField.Race;
import com.edomew.dnd.entity.characterField.Sex;
import com.edomew.dnd.service.impl.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@RestController
@RequestMapping("/characters")
@SessionAttributes("userCharacter")
public class CharacterController {

    private final CharacterServiceImpl characterService;

    @Autowired
    public CharacterController(CharacterServiceImpl characterService) {
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
        return "character-create";
    }

    @PostMapping("/loading")
    public String processCharacterCreateForm(SessionStatus status, @ModelAttribute("userCharacter") Character character) {
        Character savedCharacter = characterService.createCharacter(character);
        status.setComplete();

        return "redirect:/characters/" + savedCharacter.getCharacterId();
    }

    // Другие методы контроллера
    @GetMapping("/{id}")
    public String showComplete(@PathVariable Long id, Model model) {
        Character character = characterService.getCharacterById(id);
        System.out.println(character.toString());
        model.addAttribute("character", character);
        return "character";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        Character character = characterService.getCharacterById(id);
        model.addAttribute("character", character);
        return "character-edit";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable Long id, Model model) {
        Character character = characterService.getCharacterById(id);
        characterService.deleteCharacter(character);
        model.addAttribute("character", character);
        return "character-delete";
    }
}