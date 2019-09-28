package com.levi.rappimanager.controller;


import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Promotion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/promotion")
public class PromotionController extends AbstractCrudController<Promotion> {

    public PromotionController(AbstractCrudService<Promotion> service) {
        super(service);
    }

}
