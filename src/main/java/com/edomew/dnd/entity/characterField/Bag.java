package com.edomew.dnd.entity.characterField;

import com.edomew.dnd.entity.characterField.bagField.Item;
import com.edomew.dnd.entity.characterField.bagField.Money;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bag")
public class Bag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bag_id")
    private Long bagId;

    @Min(value = 1, message = "Вместимость сумки не может быть меньше 1")
    private Integer bagCapacity;

    @OneToMany(mappedBy = "bag")
    private List<Item> bagItems;

    @OneToOne
    @JoinColumn(name = "bag_money_id", referencedColumnName = "money_id")
    private Money bagMoney;

    public Bag() {
    }
}
