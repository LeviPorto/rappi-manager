package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends AbstractCrudRepository<Food> {

    List<Food> findByRestaurantId(Integer id);

}
