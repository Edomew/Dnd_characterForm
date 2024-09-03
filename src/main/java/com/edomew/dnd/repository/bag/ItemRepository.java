package com.edomew.dnd.repository.bag;

import com.edomew.dnd.entity.characterField.bagField.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
