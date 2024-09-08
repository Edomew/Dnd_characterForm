package com.edomew.dnd.dto_TODO;

import com.edomew.dnd.enums.EquipmentCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipmentDTO {
    private Long equipmentId;
    private String equipmentName;
    private String equipmentDescription;
    private EquipmentCategory equipmentCategory;

    // Конструкторы, геттеры и сеттеры могут быть сгенерированы Lombok
}