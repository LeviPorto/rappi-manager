package com.levi.rappimanager.controller;


import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/genericFoodTag")
public class RestaurantController extends AbstractCrudController<Restaurant> {

    public RestaurantController(AbstractCrudService<Restaurant> service) {
        super(service);
    }

}
