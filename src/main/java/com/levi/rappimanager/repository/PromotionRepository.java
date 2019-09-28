package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.Promotion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends AbstractCrudRepository<Promotion> {

    List<Promotion> findByRestaurantId(Integer id);

}
