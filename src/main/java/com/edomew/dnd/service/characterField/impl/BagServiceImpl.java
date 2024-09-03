package com.edomew.dnd.service.characterField.impl;

import com.edomew.dnd.entity.characterField.Bag;
import com.edomew.dnd.entity.characterField.bagField.Item;
import com.edomew.dnd.entity.characterField.bagField.Money;
import com.edomew.dnd.repository.BagRepository;
import com.edomew.dnd.service.characterField.BagService;
import com.edomew.dnd.service.characterField.bagField.impl.ItemServiceImpl;
import com.edomew.dnd.service.characterField.bagField.impl.MoneyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BagServiceImpl implements BagService {

    private final BagRepository bagRepository;
    private final MoneyServiceImpl moneyService;
    private final ItemServiceImpl itemServiceImpl;

    @Autowired
    public BagServiceImpl(BagRepository bagRepository, MoneyServiceImpl moneyService, ItemServiceImpl itemServiceImpl) {
        this.bagRepository = bagRepository;
        this.moneyService = moneyService;
        this.itemServiceImpl = itemServiceImpl;
    }

    @Override
    public Bag createBag(Bag bag) {
        Money money = bag.getBagMoney();
        if (money == null) {
            money = new Money();
        }
        moneyService.createMoney(money);
        bag.setBagMoney(money); // Устанавливаем сохранённый объект Money в Bag
        List<Item> items = bag.getBagItems();
        if (items == null) {
            items = new ArrayList<>();
        }
        bagRepository.save(bag);
        items.forEach(item -> {
            item.setBag(bag);
            itemServiceImpl.createItem(item);
        });
        bag.setBagItems(items);
        return bag;
    }

    @Override
    public Bag updateBag(Bag bag) {
        moneyService.updateMoney(bag.getBagMoney());
        bag.getBagItems().forEach(item -> {
            item.setBag(bag);
            itemServiceImpl.updateItem(item);
        });
        return bagRepository.save(bag);
    }

    @Override
    public void deleteBag(Bag bag) {
        if (bag == null) {
            return;
        }
        if (bag.getBagMoney() != null) {
            moneyService.deleteMoney(bag.getBagMoney().getMoneyId());
        }
        if (bag.getBagItems() != null) {
            bag.getBagItems().forEach(itemServiceImpl::deleteItem);
        }
        bagRepository.deleteById(bag.getBagId());
    }

    @Override
    public Bag getBagById(Long bagId) {
        return bagRepository.findById(bagId).orElse(new Bag());
    }

    @Override
    public List<Bag> getAllBags() {
        return bagRepository.findAll();
    }

    // Реализация методов интерфейса
}
