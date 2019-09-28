package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Combo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/combo")
public class ComboController extends AbstractCrudController<Combo> {

    public ComboController(AbstractCrudService<Combo> service) {
        super(service);
    }

}
