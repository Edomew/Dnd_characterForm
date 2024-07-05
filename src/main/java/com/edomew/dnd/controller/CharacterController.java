package com.edomew.dnd.controller;

import com.edomew.dnd.entity.*;
import com.edomew.dnd.entity.Character;
import com.edomew.dnd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/character")
public class CharacterController {

    private final CharacterRepository characterRepos;
    private final BagRepository bagRepos;
    private  final MoneyRepository moneyRepos;
    private final SkillsRepository skillsRepos;
    private final StatsRepository statsRepos;
    private final EquipRepository equipRepos;

    @Autowired
    public CharacterController(CharacterRepository characterRepository, BagRepository bagRepos, MoneyRepository moneyRepos, SkillsRepository skillsRepos, StatsRepository statsRepos, EquipRepository equipRepos) {
        this.characterRepos = characterRepository;
        this.bagRepos = bagRepos;
        this.moneyRepos = moneyRepos;
        this.skillsRepos = skillsRepos;
        this.statsRepos = statsRepos;
        this.equipRepos = equipRepos;
    }

    @GetMapping("/get-skill-fragment")
    public String getSkillFragment(Model model) {
        // Создаем пустой объект Skill и добавляем его в модель
        model.addAttribute("skill", new Skill());
        // Возвращаем имя фрагмента Thymeleaf
        return "fragments/skillFragment";
    }

    @PostMapping("/submit-character")
    public ModelAndView submitCharacterForm(@ModelAttribute Character character,
                                            @ModelAttribute(name = "statistics") Stats stats,
                                            @ModelAttribute Skills skills,
                                            @ModelAttribute Equipment equipment,
                                            @ModelAttribute Bag bag,
                                            @ModelAttribute Money money
    ) {
        // Здесь может быть логика для обработки или преобразования данных формы, если это необходимо
        statsRepos.save(stats);
        character.setCharacterStatistic(stats);
        skillsRepos.save(skills);
        character.setCharacterSkills(skills);
        moneyRepos.save(money);
        bag.setMoneyInBag(money);
        bagRepos.save(bag);
        character.setCharacterBag(bag);
        equipRepos.save(equipment);
        character.setCharacterEquip(equipment);
        // Сохраняем персонажа в базе данных
        characterRepos.save(character);

        // Перенаправляем пользователя на страницу успеха или обратно на форму с сообщением об успехе
        ModelAndView modelAndView = new ModelAndView("/success");
        modelAndView.addObject("message", "Персонаж успешно создан!");
        return modelAndView;
    }

}
