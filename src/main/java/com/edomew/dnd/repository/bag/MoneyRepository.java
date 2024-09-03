package com.edomew.dnd.repository.bag;

import com.edomew.dnd.entity.characterField.bagField.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyRepository extends JpaRepository<Money, Long> {
}
