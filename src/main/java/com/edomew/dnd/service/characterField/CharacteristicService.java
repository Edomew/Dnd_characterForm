package com.edomew.dnd.service.characterField;

import com.edomew.dnd.entity.characterField.Characteristic;

import java.util.List;

public interface CharacteristicService {
    Characteristic createCharacteristic(Characteristic characteristic);
    Characteristic updateCharacteristic(Characteristic characteristic);
    void deleteCharacteristic(Long characteristicId);
    Characteristic getCharacteristicById(Long characteristicId);
    List<Characteristic> getAllCharacteristics();
}
