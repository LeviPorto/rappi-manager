package com.levi.rappimanager.controller;


import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.domain.Promotion;
import com.levi.rappimanager.service.PromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/promotion")
public class PromotionController extends AbstractCrudController<Promotion> {

    private final PromotionService service;

    public PromotionController(final PromotionService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/search")
    public List<Promotion> getFilteredPromotions(@RequestParam String searchedName, @RequestParam String userCity) {
        return service.retrieveFilteredPromotions(searchedName, userCity);
    }

}
