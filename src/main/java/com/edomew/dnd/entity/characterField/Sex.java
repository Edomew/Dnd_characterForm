package com.edomew.dnd.entity.characterField;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum Sex {
    MALE("Мужской"), FEMALE("Женский"), OTHER("Другой");

    private final String name;

    Sex(String name) {
        this.name = name;
    }

    public static List<String> getAllNames(){
        List<String> list = new ArrayList<>();
        for (Sex sex : Sex.values()) {
            list.add(sex.name);
        }
        return list;
    }

}
