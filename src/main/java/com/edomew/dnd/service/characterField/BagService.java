package com.edomew.dnd.service.characterField;

import com.edomew.dnd.entity.characterField.Bag;

import java.util.List;

public interface BagService {
    Bag createBag(Bag bag);
    Bag updateBag(Bag bag);

    void deleteBag(Bag bag);

    Bag getBagById(Long bagId);
    List<Bag> getAllBags();
}

