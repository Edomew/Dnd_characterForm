package com.edomew.dnd.dto_TODO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacteristicDTO {
    private Long characteristicId;
    private String characteristicName;
    private Integer valueOfCharacteristic;

    // Конструкторы, геттеры и сеттеры могут быть сгенерированы Lombok
}