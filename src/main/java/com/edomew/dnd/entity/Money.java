package com.edomew.dnd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "money")
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "moneyId")
    private int moneyId;
    private float amountOfMoney;
    private int gold;
    private int silver;
    private int bronze;

    public Money(float amount, int gold, int silver, int bronze) {
        this.amountOfMoney = amount;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public Money() {

    }
}
