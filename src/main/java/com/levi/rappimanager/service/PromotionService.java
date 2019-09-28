package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Promotion;
import org.springframework.stereotype.Service;

@Service
public class PromotionService extends AbstractCrudService<Promotion> {

    public PromotionService(AbstractCrudRepository<Promotion> repository) {
        super(repository);
    }

}
