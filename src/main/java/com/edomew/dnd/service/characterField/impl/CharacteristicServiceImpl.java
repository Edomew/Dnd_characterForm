package com.edomew.dnd.service.characterField.impl;

import com.edomew.dnd.entity.characterField.Characteristic;
import com.edomew.dnd.repository.CharacteristicRepository;
import com.edomew.dnd.service.characterField.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicServiceImpl implements CharacteristicService {

    private final CharacteristicRepository characteristicRepository;

    @Autowired
    public CharacteristicServiceImpl(CharacteristicRepository characteristicRepository) {
        this.characteristicRepository = characteristicRepository;
    }

    @Override
    public Characteristic createCharacteristic(Characteristic characteristic) {
        if (characteristic.getCharacteristicName()==null){
            characteristic.setCharacteristicName("");
        }
        if (characteristic.getValueOfCharacteristic()<0){
            characteristic.setValueOfCharacteristic(0);
        }
        return characteristicRepository.save(characteristic);
    }

    @Override
    public Characteristic updateCharacteristic(Characteristic characteristic) {
        return characteristicRepository.save(characteristic);
    }

    @Override
    public void deleteCharacteristic(Long characteristicId) {
        characteristicRepository.deleteById(characteristicId);
    }

    @Override
    public Characteristic getCharacteristicById(Long characteristicId) {
        return characteristicRepository.findById(characteristicId).isPresent()
                ?
                characteristicRepository.findById(characteristicId).get()
                :
                null;
    }

    @Override
    public List<Characteristic> getAllCharacteristics() {
        return characteristicRepository.findAll();
    }

    // Реализация методов интерфейса
}
