package com.edomew.dnd.service;

import com.edomew.dnd.entity.Character;

import java.util.List;

public interface CharacterService {

    Character createCharacter(Character character);

    Character updateCharacter(Character character);

    void deleteCharacter(Character character);

    Character getCharacterById(Long characterId);

    List<Character> getAllCharacters();
}
