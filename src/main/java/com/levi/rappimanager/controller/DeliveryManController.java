package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.DeliveryMan;
import com.levi.rappimanager.service.DeliveryManService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/deliveryMan")
public class DeliveryManController extends AbstractCrudController<DeliveryMan> {

    private final DeliveryManService service;

    public DeliveryManController(final DeliveryManService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("restaurant/{restaurantId}/waitingAcceptance")
    public List<DeliveryMan> findByRestaurantAndWaitingAcceptance(@PathVariable Integer restaurantId) {
        return service.retrieveByRestaurantAndWaitingAcceptance(restaurantId);
    }

    @PutMapping("/{id}/acceptJob")
    public DeliveryMan acceptJob(@PathVariable Integer id) {
        return service.acceptJob(id);
    }

}
