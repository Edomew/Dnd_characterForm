package com.edomew.dnd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "character_id")
    private int characterId;

    private String characterName;
    private String characterSex;
    private String characterRace;
    private String characterClass;

    private byte characterLevel;
    private byte characterAge;
    @OneToOne
    private Equipment characterEquip;
    @OneToOne
    private Bag characterBag;
    @OneToOne
    private Stats characterStatistic;

    private int characterBonusDamage;
    @OneToOne
    private Skills characterSkills;
    @Column(length = 2000)
    private String historyOfCharacter;

    public Character() {
    }

}
