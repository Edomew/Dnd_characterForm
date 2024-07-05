package com.edomew.dnd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bags")
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bag_id")
    private Long bagId;
    private float bagValue;
    private int bagQuantity;
    @ManyToOne
    private Item itemsInBag;
    @OneToOne
    private Money moneyInBag;
    @OneToOne
    private Equipment equipment;

    public Bag(float value, int quantity, Item items, Money money) {
        this.bagValue = value;
        this.bagQuantity = quantity;
        this.itemsInBag = items;
        this.moneyInBag = money;
    }

    public Bag() {

    }

    public Bag(Money money) {
        this.moneyInBag = money;
    }
}
