package com.edomew.dnd.service.characterField.bagField;

import com.edomew.dnd.entity.characterField.bagField.Money;

import java.util.List;

public interface MoneyService {
    Money createMoney(Money money);
    Money updateMoney(Money money);
    void deleteMoney(Long moneyId);
    Money getMoneyById(Long moneyId);
    List<Money> getAllMoney();
}
