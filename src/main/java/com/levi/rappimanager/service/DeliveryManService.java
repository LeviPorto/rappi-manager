package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.DeliveryMan;
import org.springframework.stereotype.Service;

@Service
public class DeliveryManService extends AbstractCrudService<DeliveryMan> {

    public DeliveryManService(AbstractCrudRepository<DeliveryMan> repository) {
        super(repository);
    }

}
