package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.domain.Food;
import com.levi.rappimanager.service.FoodService;
import org.springframework.web.bind.annotation.*;

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
    public List<Food> getFilteredFoods(@RequestParam String searchedName, @RequestParam String userCity,
                                       @RequestParam Integer userId) {
        return service.retrieveFilteredFoods(searchedName, userCity, userId);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Food> findByRestaurant(@PathVariable Integer restaurantId) {
        return service.retrieveByRestaurant(restaurantId);
    }

}
