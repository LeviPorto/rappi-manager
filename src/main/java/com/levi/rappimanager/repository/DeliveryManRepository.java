package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.DeliveryMan;
import com.levi.rappimanager.domain.enumeration.Occupation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryManRepository extends AbstractCrudRepository<DeliveryMan> {

    DeliveryMan findTop1ByRestaurantIdAndOccupation(Integer restaurantId, Occupation occupation);

    List<DeliveryMan> findByRestaurantIdAndOccupation(Integer restaurantId, Occupation occupation);
}
