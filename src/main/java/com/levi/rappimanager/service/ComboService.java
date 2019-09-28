package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Combo;
import org.springframework.stereotype.Service;

@Service
public class ComboService extends AbstractCrudService<Combo> {

    public ComboService(AbstractCrudRepository<Combo> repository) {
        super(repository);
    }

}
