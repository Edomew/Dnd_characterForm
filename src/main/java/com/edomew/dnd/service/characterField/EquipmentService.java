package com.edomew.dnd.service.characterField;

import com.edomew.dnd.entity.characterField.Equipment;

import java.util.List;

public interface EquipmentService {
    Equipment createEquipment(Equipment equipment);
    Equipment updateEquipment(Equipment equipment);
    void deleteEquipment(Long equipmentId);
    Equipment getEquipmentById(Long equipmentId);
    List<Equipment> getAllEquipments();
}
