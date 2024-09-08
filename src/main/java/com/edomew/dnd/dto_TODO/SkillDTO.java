package com.edomew.dnd.dto_TODO;

import com.edomew.dnd.enums.InfluenceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillDTO {
    private Long skillId;
    private String skillName;
    private int skillLevel;
    private InfluenceType skillInfluence;
    private int skillInfluencePoints;
    private String skillDescription;

    // Конструкторы, геттеры и сеттеры могут быть сгенерированы Lombok
}