package com.edomew.dnd.repository;

import com.edomew.dnd.entity.characterField.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends JpaRepository<Bag, Long> {
}
