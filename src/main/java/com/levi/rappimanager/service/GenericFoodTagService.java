package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.GenericFoodTag;
import org.springframework.stereotype.Service;

@Service
public class GenericFoodTagService extends AbstractCrudService<GenericFoodTag> {

    public GenericFoodTagService(AbstractCrudRepository<GenericFoodTag> repository) {
        super(repository);
    }

}
