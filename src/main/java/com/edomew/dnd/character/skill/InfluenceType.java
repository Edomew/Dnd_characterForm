package com.edomew.dnd.character.skill;

import lombok.Getter;

@Getter
public enum InfluenceType {
    PHYSICAL_DAMAGE("Физический урон"),
    MAGICAL_DAMAGE("Магический урон"),
    HEALING("Исцеление"),
    SHIELD("Щит"),
    CONTROL("Контроль");

    private final String description;

    InfluenceType(String description) {
        this.description = description;
    }

}
