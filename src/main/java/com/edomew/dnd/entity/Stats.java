package com.edomew.dnd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "character_stats")
public class Stats{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stats_id")
    private int statsId;
    @OneToMany(mappedBy = "stats", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Stat> stats = new ArrayList<>();
    @OneToOne
    private Character character;

    public Stats() {
        // Создаем стандартные статы для каждого нового объекта Stats
        stats.add(new Stat("Сила"));
        stats.add(new Stat("Ловкость"));
        stats.add(new Stat("Интеллект"));
        stats.add(new Stat("Мудрость"));
    }

}
