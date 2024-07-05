package com.edomew.dnd.character;

import lombok.Getter;

@Getter
public enum Category {
    CLOTHES("Одежда"),
    WEAPON("Оружие"),
    GRIMOIRE("Гримуар"),
    POTION("Зелье");
    private final String name;
    Category(String name) {
        this.name = name;
    }
}
