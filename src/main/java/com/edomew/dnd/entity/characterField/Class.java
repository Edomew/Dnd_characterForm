package com.edomew.dnd.entity.characterField;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum Class {
    WARRIOR("Воин", "Отважные бойцы, способные выдержать множество ударов и наносить сокрушительные атаки."),
    MAGE("Маг", "Мастера арканной магии, использующие заклинания для контроля над силами стихий."),
    ROGUE("Разбойник", "Ловкие и хитрые, мастера скрытности и неожиданных атак."),
    PRIEST("Жрец", "Служители божеств, исцеляющие раны и помогающие союзникам."),
    PALADIN("Паладин", "Святые воины, защищающие слабых и борющиеся с злом."),
    RANGER("Следопыт", "Опытные охотники и исследователи, мастера выживания."),
    WARLOCK("Колдун", "Получают свои силы благодаря договорам с могущественными сущностями.");

    private final String name;
    private final String description;

    Class(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static List<String> getAllNames(){
        List<String> list = new ArrayList<>();
        for (Class _class : Class.values()) {
            list.add(_class.name);
        }
        return list;
    }

}
