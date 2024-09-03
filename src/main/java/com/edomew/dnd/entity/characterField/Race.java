package com.edomew.dnd.entity.characterField;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum Race {
    HUMAN("Человек", "Самая многочисленная и разнообразная раса в мире."),
    ELF("Эльф", "Изящные, долгоживущие создания, обладающие острым умом и природной ловкостью."),
    DWARF("Дварф", "Коренастые и выносливые воины с глубокими традициями ремесленничества."),
    GNOME("Гном", "Маленькие, но изобретательные и энергичные создания с острым чувством юмора."),
    HALF_ELF("Полуэльф", "Существа, сочетающие в себе черты эльфов и людей."),
    HALF_ORC("Полуорк", "Мощные воины, в которых течет кровь и орков, и людей."),
    TIEFLING("Тифлинг", "Имеют демонические предки, что придает им уникальные способности и внешность.");

    private final String name;
    private final String description;

    Race(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static List<String> getAllNames(){
        List<String> list = new ArrayList<>();
        for (Race race : Race.values()) {
            list.add(race.name);
        }
        return list;
    }

}
