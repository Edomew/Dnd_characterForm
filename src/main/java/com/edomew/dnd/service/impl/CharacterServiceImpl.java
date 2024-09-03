package com.edomew.dnd.service.impl;

import com.edomew.dnd.entity.Character;
import com.edomew.dnd.entity.characterField.Bag;
import com.edomew.dnd.entity.characterField.Characteristic;
import com.edomew.dnd.entity.characterField.Equipment;
import com.edomew.dnd.entity.characterField.Skill;
import com.edomew.dnd.entity.characterField.bagField.Money;
import com.edomew.dnd.repository.CharacterRepository;
import com.edomew.dnd.service.CharacterService;
import com.edomew.dnd.service.characterField.impl.BagServiceImpl;
import com.edomew.dnd.service.characterField.impl.CharacteristicServiceImpl;
import com.edomew.dnd.service.characterField.impl.EquipmentServiceImpl;
import com.edomew.dnd.service.characterField.impl.SkillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final BagServiceImpl bagService;
    private final EquipmentServiceImpl equipmentService;
    private final SkillServiceImpl skillService;
    private final CharacteristicServiceImpl characteristicService;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository, BagServiceImpl bagService, EquipmentServiceImpl equipmentService, SkillServiceImpl skillService, CharacteristicServiceImpl characteristicService) {
        this.characterRepository = characterRepository;
        this.bagService = bagService;
        this.equipmentService = equipmentService;
        this.skillService = skillService;
        this.characteristicService = characteristicService;
    }

    @Override
    public Character createCharacter(Character character) {
        if (character == null) {
            System.out.println("Character is null");
            character = new Character();
            character.setCharacterBag(new Bag());
            character.setCharacterSkills(new ArrayList<>());
            character.setCharacterCharacteristics(new ArrayList<>());
            character.setCharacterEquipment(new ArrayList<>());
            bagService.createBag(character.getCharacterBag());
            character.getCharacterSkills().forEach(skillService::createSkill);
            character.getCharacterCharacteristics().forEach(characteristicService::createCharacteristic);
            character.getCharacterEquipment().forEach(equipmentService::createEquipment);
            return characterRepository.save(character);
        }
        // Валидация и бизнес-логика перед сохранением
        Bag bag = character.getCharacterBag();
        List<Characteristic> characteristics = character.getCharacterCharacteristics();
        List<Skill> skills = character.getCharacterSkills();
        List<Equipment> equipments = character.getCharacterEquipment();
        if (bag == null) {
            bag = new Bag();
            bag.setBagMoney(new Money());
        }
        if (characteristics == null) {
            characteristics = new ArrayList<>();
        }
        if (skills == null) {
            skills = new ArrayList<>();
        }
        if (equipments == null) {
            equipments = new ArrayList<>();
        }
        // Сохраняем рюкзак в бд
        bagService.createBag(bag);
        // Добавляем сохранённый рюкзак персонажу
        character.setCharacterBag(bag);
        // Сохраняем скилы в бд
        skills.forEach(skillService::createSkill);
        // Добавляем скилы персонажу
        character.setCharacterSkills(skills);

        equipments.forEach(equipmentService::createEquipment);

        character.setCharacterEquipment(equipments);

        characteristics.forEach(characteristicService::createCharacteristic);

        character.setCharacterCharacteristics(characteristics);

        Character savedCharacter = characterRepository.save(character);
        savedCharacter.getCharacterCharacteristics().forEach(characteristic -> {
            characteristic.setCharacter(savedCharacter);
            characteristicService.updateCharacteristic(characteristic);
        });
        savedCharacter.getCharacterEquipment().forEach(equipment -> {
            equipment.setCharacter(savedCharacter);
            equipmentService.updateEquipment(equipment);
        });
        savedCharacter.getCharacterSkills().forEach(skill -> {
            skill.setCharacter(savedCharacter);
            skillService.updateSkill(skill);
        });
        return savedCharacter;
    }

    @Override
    public Character updateCharacter(Character character) {
        if (character == null) {
            throw new NullPointerException();
        }
        bagService.updateBag(character.getCharacterBag());
        character.getCharacterSkills().forEach(skill -> {
            skill.setCharacter(character);
            skillService.updateSkill(skill);
        });
        character.getCharacterCharacteristics().forEach(characteristic -> {
            characteristic.setCharacter(character);
            characteristicService.updateCharacteristic(characteristic);
        });
        character.getCharacterEquipment().forEach(equipment -> {
            equipment.setCharacter(character);
            equipmentService.updateEquipment(equipment);
        });
        // Валидация и бизнес-логика перед обновлением
        return characterRepository.save(character);
    }

    @Override
    public void deleteCharacter(Character character) {
        if (character == null || character.getCharacterId() == null) {
            return;
        }
        bagService.deleteBag(character.getCharacterBag());
        character.getCharacterCharacteristics().forEach(characteristic -> {
            characteristicService.deleteCharacteristic(characteristic.getCharacteristicId());
        });
        character.getCharacterSkills().forEach(skill -> {
            skillService.deleteSkill(skill.getSkillId());
        });
        character.getCharacterEquipment().forEach(equipment -> {
            equipmentService.deleteEquipment(equipment.getEquipmentId());
        });
        characterRepository.delete(character);
    }

    @Override
    public Character getCharacterById(Long characterId) {
        return characterRepository.findById(characterId).orElse(null);
    }

    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }
}
