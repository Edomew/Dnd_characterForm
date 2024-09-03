package com.edomew.dnd.entity.characterField.bagField;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "money")
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "money_id")
    private Long moneyId;

    @DecimalMin(value = "0.0000", message = "Сумма денег не может быть меньше нуля")
    private Float amountOfMoney;

    @Min(value = 0, message = "Количество золота не может быть меньше нуля")
    private Integer gold;

    @Min(value = 0, message = "Количество серебра не может быть меньше нуля")
    @Max(value = 99, message = "Количество серебра не может быть больше 99")
    private Integer silver;

    @Min(value = 0, message = "Количество бронзы не может быть меньше нуля")
    @Max(value = 99, message = "Количество бронзы не может быть больше 99")
    private Integer bronze;

    public Money() {

    }
}
