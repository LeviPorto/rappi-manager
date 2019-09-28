package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.Combo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComboRepository extends AbstractCrudRepository<Combo> {

    List<Combo> findByRestaurantId(Integer id);

}
