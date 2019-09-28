package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.domain.Food;
import com.levi.rappimanager.service.FoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/food")
public class FoodController extends AbstractCrudController<Food> {

    private final FoodService service;

    public FoodController(final FoodService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/search")
    public List<Food> getFilteredFoods(@RequestParam String searchedName, @RequestParam String userCity) {
        return service.retrieveFilteredFoods(searchedName, userCity);
    }

}
