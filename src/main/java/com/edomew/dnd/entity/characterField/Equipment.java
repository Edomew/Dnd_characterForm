package com.edomew.dnd.entity.characterField;

import com.edomew.dnd.entity.Character;
import com.edomew.dnd.enums.EquipmentCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "equipment_id")
    private Long equipmentId;

    @NotBlank(message = "Название снаряжения не может быть пустым")
    @Pattern(regexp = ".*\\p{L}.*", message = "Название снаряжения должно содержать буквы")
    private String equipmentName;

    @NotBlank(message = "Описание снаряжения не может быть пустым")
    @Pattern(regexp = ".*\\p{L}.*", message = "Описание снаряжения должно содержать буквы")
    private String equipmentDescription;

    @NotNull(message = "Категория снаряжения не может быть пустой")
    @Enumerated(EnumType.STRING)
    private EquipmentCategory equipmentCategory;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;
}
