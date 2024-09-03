package com.edomew.dnd.entity;

import com.edomew.dnd.entity.characterField.Class;
import com.edomew.dnd.entity.characterField.*;
import com.edomew.dnd.service.characterField.BagService;
import com.edomew.dnd.service.characterField.impl.BagServiceImpl;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "user_character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "character_id")
    private Long characterId;

    @NotBlank(message = "Имя персонажа не может быть пустым")
    @Pattern(regexp = "^[\\p{L}]+$", message = "Имя персонажа должно содержать только буквы")
    private String characterName;

    @NotNull(message = "Пол персонажа не может быть пустым")
    @Enumerated(EnumType.STRING)
    private Sex characterSex;

    @NotNull(message = "Раса персонажа не может быть пустой")
    @Enumerated(EnumType.STRING)
    private Race characterRace;

    @NotNull(message = "Класс персонажа не может быть пустым")
    @Enumerated(EnumType.STRING)
    private Class characterClass;

    @Min(value = 1, message = "Уровень персонажа не может быть меньше 1")
    @Max(value = 20, message = "Уровень персонажа не может быть больше 20")
    private byte characterLevel;

    @Min(value = 1, message = "Возраст персонажа не может быть меньше 1")
    private byte characterAge;

    @Min(value = 0, message = "Бонус урона не может быть меньше 0")
    private Integer characterBonusDamage;

    @OneToOne
    @JoinColumn(name = "character_bag_id", referencedColumnName = "bag_id")
    private Bag characterBag;

    @OneToMany(mappedBy = "character",fetch = FetchType.EAGER)
    private List<Characteristic> characterCharacteristics;

    @OneToMany(mappedBy = "character",fetch = FetchType.EAGER)
    private List<Skill> characterSkills;

    @OneToMany(mappedBy = "character",fetch = FetchType.EAGER)
    private List<Equipment> characterEquipment;

    @Size(min = 100, message = "История персонажа должна содержать не менее 100 символов")
    @Column(length = 2000)
    private String historyOfCharacter;

    public Character() {

        characterAge = 1;
        characterLevel = 1;
        characterBonusDamage = 0;

        characterCharacteristics = new ArrayList<>();
        characterCharacteristics.add(new Characteristic("Сила"));
        characterCharacteristics.add(new Characteristic("Ловкость"));
        characterCharacteristics.add(new Characteristic("Интеллект"));
        characterCharacteristics.add(new Characteristic("Мудрость"));
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Characteristic characteristic : characterCharacteristics){
            stringBuilder.append(characteristic.toString());
        }
        String characteristics = stringBuilder.toString();
        return "\nCharacterName: " + this.characterName+
                "\nCharacterAge: " + this.characterAge+
                "\nCharacterMoney: "+this.getCharacterBag().getBagMoney().getAmountOfMoney()+
                "\nBagCapacity: "+this.getCharacterBag().getBagCapacity()+
                "\nCharacteristics:\n"+characteristics;
    }

}
