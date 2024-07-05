package com.edomew.dnd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stat")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stat_id")
    private int statId;
    private int valueOfStat;
    private String statName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stats_id")
    private Stats stats;

    public Stat(String statName) {
        this.statName = statName;
    }

    public Stat() {

    }
}
