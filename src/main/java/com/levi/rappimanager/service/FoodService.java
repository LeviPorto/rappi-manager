package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Food;
import org.springframework.stereotype.Service;

@Service
public class FoodService extends AbstractCrudService<Food> {

    public FoodService(AbstractCrudRepository<Food> repository) {
        super(repository);
    }

}
