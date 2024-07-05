package com.edomew.dnd.entity;

import com.edomew.dnd.character.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private int itemId;
    private int amountOfItems;
    private String itemName;
    private String itemDescription;
    private Category itemCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;


    public Item() {

    }

    @Override
    public String toString() {
        return "\n\tНазвание: " + itemName +
                "\n\tКоличество: " + amountOfItems +
                "\n\tКатегория: " + itemCategory.getName() +
                "\n\tОписание: " + itemDescription;

    }
}
