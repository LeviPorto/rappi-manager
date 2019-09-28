package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.GenericFoodTag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/genericFoodTag")
public class GenericFoodTagController extends AbstractCrudController<GenericFoodTag> {

    public GenericFoodTagController(AbstractCrudService<GenericFoodTag> service) {
        super(service);
    }

}
