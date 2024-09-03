package com.edomew.dnd.entity.characterField.bagField;

import com.edomew.dnd.entity.characterField.Bag;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long itemId;

    @NotBlank(message = "Название предмета не может быть пустым")
    @Pattern(regexp = ".*\\p{L}.*", message = "Название предмета должно содержать буквы")
    private String itemName;

    @NotBlank(message = "Описание предмета не может быть пустым")
    @Pattern(regexp = ".*\\p{L}.*", message = "Описание предмета должно содержать буквы")
    @Column(length = 2000)
    private String itemDescription;

    @NotBlank(message = "Категория предмета не может быть пустой")
    @Pattern(regexp = ".*\\p{L}.*", message = "Категория предмета должна содержать буквы")
    private String itemCategory;

    @ManyToOne
    @JoinColumn(name = "bag_id")
    private Bag bag;

    public Item() {
    }
}
