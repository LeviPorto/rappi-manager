package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends AbstractCrudRepository<Restaurant> {

    Restaurant findByDeliveryManId(Integer deliveryManId);

}
