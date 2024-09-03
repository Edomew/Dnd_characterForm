package com.edomew.dnd.service.characterField.bagField.impl;

import com.edomew.dnd.entity.characterField.bagField.Item;
import com.edomew.dnd.repository.bag.ItemRepository;
import com.edomew.dnd.service.characterField.bagField.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(Item item) {
        if (item == null){
            item = new Item();
        }
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        if (item == null){
            item = new Item();
        }
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepository.deleteById(item.getItemId());
    }

    @Override
    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Реализация методов интерфейса
}
