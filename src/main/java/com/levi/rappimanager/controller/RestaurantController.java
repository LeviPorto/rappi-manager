package com.levi.rappimanager.controller;


import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.dto.FilteredRestaurantDTO;
import com.levi.rappimanager.dto.RestaurantSearchDTO;
import com.levi.rappimanager.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/restaurant")
public class RestaurantController extends AbstractCrudController<Restaurant> {

    private final RestaurantService service;

    public RestaurantController(final RestaurantService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/deliveryMan/{deliveryManId}")
    public Restaurant findByDeliveryMan(@PathVariable Integer deliveryManId) {
        return service.retrieveByDeliveryMan(deliveryManId);
    }

    @PostMapping("/search")
    public List<FilteredRestaurantDTO> search(@RequestBody RestaurantSearchDTO restaurantSearchDTO) {
        return service.retrieveFilteredRestaurants(restaurantSearchDTO);
    }

}
