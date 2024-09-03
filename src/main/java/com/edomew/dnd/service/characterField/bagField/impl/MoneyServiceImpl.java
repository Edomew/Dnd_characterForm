package com.edomew.dnd.service.characterField.bagField.impl;

import com.edomew.dnd.entity.characterField.bagField.Money;
import com.edomew.dnd.repository.bag.MoneyRepository;
import com.edomew.dnd.service.characterField.bagField.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyService {

    private final MoneyRepository moneyRepository;

    @Autowired
    public MoneyServiceImpl(MoneyRepository moneyRepository) {
        this.moneyRepository = moneyRepository;
    }

    @Override
    public Money createMoney(Money money) {
        if (money.getGold() < 0 || money.getBronze() < 0 || money.getSilver() < 0) {
            throw new IllegalArgumentException("Money needs to be greater than 0");
        } else if (money.getGold() > 0 || money.getBronze() > 0 || money.getSilver() > 0) {
            Float amountOfMoney = Float.valueOf(money.getGold());
            amountOfMoney += (float) money.getSilver() / 100;
            amountOfMoney += (float) money.getBronze() / 10000;
            if (money.getAmountOfMoney()!=amountOfMoney) {
                money.setAmountOfMoney(amountOfMoney);
            }
        }

        return moneyRepository.save(money);
    }

    @Override
    public Money updateMoney(Money money) {
        return moneyRepository.save(money);
    }

    @Override
    public void deleteMoney(Long moneyId) {
        moneyRepository.deleteById(moneyId);
    }

    @Override
    public Money getMoneyById(Long moneyId) {
        return moneyRepository.getReferenceById(moneyId);
    }

    @Override
    public List<Money> getAllMoney() {
        return moneyRepository.findAll();
    }

    // Реализация методов интерфейса
}
