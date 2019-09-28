package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.ComboItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/comboItem")
public class ComboItemController extends AbstractCrudController<ComboItem> {

    public ComboItemController(AbstractCrudService<ComboItem> service) {
        super(service);
    }

}
