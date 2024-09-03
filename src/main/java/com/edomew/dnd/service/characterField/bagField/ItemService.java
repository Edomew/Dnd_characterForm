package com.edomew.dnd.service.characterField.bagField;

import com.edomew.dnd.entity.characterField.bagField.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);

    Item updateItem(Item item);


    void deleteItem(Item item);

    Item getItemById(Long itemId);

    List<Item> getAllItems();
}
