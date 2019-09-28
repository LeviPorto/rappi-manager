package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.PromotionItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/promotionItem")
public class PromotionItemController extends AbstractCrudController<PromotionItem> {

    public PromotionItemController(AbstractCrudService<PromotionItem> service) {
        super(service);
    }

}
