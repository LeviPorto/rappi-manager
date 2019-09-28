package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.ComboItem;
import org.springframework.stereotype.Service;

@Service
public class ComboItemService extends AbstractCrudService<ComboItem> {

    public ComboItemService(AbstractCrudRepository<ComboItem> repository) {
        super(repository);
    }

}
