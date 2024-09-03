package com.edomew.dnd.entity.characterField;

import com.edomew.dnd.entity.Character;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "characteristic")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "characteristic_id")
    private Long characteristicId;

    @NotBlank(message = "Название характеристики не может быть пустым")
    @Pattern(regexp = "^[\\p{L}]+$", message = "Название характеристики должно содержать только буквы")
    private String characteristicName;

    @Min(value = 1, message = "Значение характеристики должно быть не меньше 1")
    private Integer valueOfCharacteristic;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    public Characteristic(String characteristicName) {
        this.characteristicName = characteristicName;
    }

    public Characteristic() {

    }

    @Override
    public String toString() {
        return "\t"+characteristicName+": "+valueOfCharacteristic+"\n";
    }
}

