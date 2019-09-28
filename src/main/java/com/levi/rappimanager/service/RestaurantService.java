package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Restaurant;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends AbstractCrudService<Restaurant> {

    public RestaurantService(AbstractCrudRepository<Restaurant> repository) {
        super(repository);
    }

}
