package com.edomew.dnd.repository;

import com.edomew.dnd.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipRepository extends JpaRepository<Equipment, Integer> {
}
