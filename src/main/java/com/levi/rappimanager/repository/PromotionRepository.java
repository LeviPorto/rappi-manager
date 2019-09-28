package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.Promotion;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends AbstractCrudRepository<Promotion> {
}
