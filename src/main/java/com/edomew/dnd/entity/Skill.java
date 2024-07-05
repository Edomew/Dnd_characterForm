package com.edomew.dnd.entity;

import com.edomew.dnd.character.skill.InfluenceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "skill_list")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int skillId;
    private String skillName;
    private int skillLevel;
    private InfluenceType skillInfluence;
    private int skillInfluencePoints;
    private String skillDescription;
    @ManyToOne
    private Skills skills;

    public Skill() {
    }
}
