package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.DeliveryMan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/deliveryMan")
public class DeliveryManController extends AbstractCrudController<DeliveryMan> {

    public DeliveryManController(AbstractCrudService<DeliveryMan> service) {
        super(service);
    }

}
