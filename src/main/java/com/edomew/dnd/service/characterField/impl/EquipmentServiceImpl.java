package com.edomew.dnd.service.characterField.impl;

import com.edomew.dnd.entity.characterField.Equipment;
import com.edomew.dnd.repository.EquipmentRepository;
import com.edomew.dnd.service.characterField.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipment(Long equipmentId) {
        equipmentRepository.deleteById(equipmentId);
    }

    @Override
    public Equipment getEquipmentById(Long equipmentId) {
        return equipmentRepository.findById(equipmentId).isPresent()
                ?
                equipmentRepository.findById(equipmentId).get()
                :
                null;
    }

    @Override
    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    // Реализация методов интерфейса
}
