package com.edomew.dnd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "character_skills")
@Getter
@Setter
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skills_id")
    private int skillsId;
    @OneToMany
    private List<Skill> skills;
    @OneToOne
    private Character character;
    public Skills() {

    }

}
