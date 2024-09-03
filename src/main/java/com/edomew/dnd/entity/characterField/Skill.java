package com.edomew.dnd.entity.characterField;

import com.edomew.dnd.entity.Character;
import com.edomew.dnd.enums.InfluenceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id")
    private Long skillId;

    @NotBlank(message = "Название навыка не может быть пустым")
    @Pattern(regexp = ".*\\p{L}.*", message = "Название навыка должно содержать буквы")
    private String skillName;

    @Min(value = 1, message = "Уровень навыка должен быть не меньше 1")
    private int skillLevel;

    @NotNull(message = "Тип влияния навыка не может быть пустым")
    private InfluenceType skillInfluence;

    @Min(value = 1, message = "Количество очков влияния навыка должно быть не меньше 1")
    private int skillInfluencePoints;

    @NotBlank(message = "Описание навыка не может быть пустым")
    @Pattern(regexp = ".*\\p{L}.*", message = "Описание навыка должно содержать буквы")
    private String skillDescription;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    public Skill() {

    }
}