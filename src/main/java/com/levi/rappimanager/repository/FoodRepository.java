package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends AbstractCrudRepository<Food> {
}
