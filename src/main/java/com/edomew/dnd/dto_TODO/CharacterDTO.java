package com.edomew.dnd.dto_TODO;

import com.edomew.dnd.entity.characterField.Class;
import com.edomew.dnd.entity.characterField.Race;
import com.edomew.dnd.entity.characterField.Sex;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private Long characterId;
    private String characterName;
    private Sex characterSex;
    private Race characterRace;
    private Class characterClass;
    private byte characterLevel;
    private byte characterAge;
    private Integer characterBonusDamage;
    private String historyOfCharacter;
    private BagDTO characterBag;
    private List<CharacteristicDTO> characterCharacteristics;
    private List<SkillDTO> characterSkills;
    private List<EquipmentDTO> characterEquipment;

    // Конструкторы, геттеры и сеттеры могут быть сгенерированы Lombok
}