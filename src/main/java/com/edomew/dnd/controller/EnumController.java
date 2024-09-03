package com.edomew.dnd.controller;

import com.edomew.dnd.enums.InfluenceType;
import com.edomew.dnd.enums.EquipmentCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enumValues")
public class EnumController {

    @GetMapping("/influenceType")
    public Map<String, String> influenceTypeValues() {
        return Arrays.stream(InfluenceType.values())
                .collect(Collectors.toMap(InfluenceType::name, InfluenceType::getDescription));
    }

    @GetMapping("/equipmentCategory")
    public Map<String, String> equipmentCategoryValues() {
        return Arrays.stream(EquipmentCategory.values()).collect(Collectors.toMap(EquipmentCategory::name, EquipmentCategory::getName));
    }



}
