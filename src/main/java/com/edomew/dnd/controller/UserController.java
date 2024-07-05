package com.edomew.dnd.controller;

import com.edomew.dnd.entity.Character;
import com.edomew.dnd.entity.*;
import com.edomew.dnd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {



    @GetMapping(value = {"/", "/home"})
    public String homePage(Model model) {
        model.addAttribute("user", true);
        return "home";
    }

    @GetMapping("/success")
    public String success(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("message", message);
        return "success";
    }


    @GetMapping("/form")
    public String form(Model model) {
        Character character = new Character();
        character.setCharacterStatistic(new Stats());
        character.setCharacterSkills(new Skills());
        Bag bag = new Bag(new Money());
        character.setCharacterBag(bag);
        character.setCharacterEquip(new Equipment());
        model.addAttribute("character", character);
        model.addAttribute("statistics", character.getCharacterStatistic());
        model.addAttribute("skills", character.getCharacterSkills());
        model.addAttribute("equipment", character.getCharacterEquip());
        model.addAttribute("bag", character.getCharacterBag());
        model.addAttribute("money", bag.getMoneyInBag());
        return "characterForm";
    }




}
