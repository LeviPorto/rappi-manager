package com.levi.rappimanager.listener;

import com.levi.rappimanager.domain.DeliveryMan;
import com.levi.rappimanager.domain.enumeration.Occupation;
import com.levi.rappimanager.dto.OrderDTO;
import com.levi.rappimanager.service.DeliveryManService;
import org.springframework.stereotype.Component;

@Component
public class OrderAutomaticPassToDeliveryMan implements OrderCreateListener {

    private final DeliveryManService deliveryManService;

    public OrderAutomaticPassToDeliveryMan(DeliveryManService deliveryManService) {
        this.deliveryManService = deliveryManService;
    }

    @Override
    public void orderWasCreate(OrderDTO orderDTO) {
        DeliveryMan firstFreeDeliveryMan = deliveryManService.retrieveFirstFreeDeliveryMan(orderDTO.getRestaurantId());
        firstFreeDeliveryMan.setOccupation(Occupation.WAITING_ACCEPTANCE);
    }

}
