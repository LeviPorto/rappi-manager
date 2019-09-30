package com.levi.rappimanager.listener;

import com.levi.rappimanager.domain.DeliveryMan;
import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.domain.enumeration.Occupation;
import com.levi.rappimanager.dto.CoordinateDTO;
import com.levi.rappimanager.service.DeliveryManService;
import org.springframework.stereotype.Component;

import static com.levi.rappimanager.util.DistanceCalculatorUtil.calculateDistanceBetweenPoints;

@Component
public class DeliveryManUpdateOccupationToFreeListener implements CoordinateCreatedListener {

    private final DeliveryManService deliveryManService;

    private static final int DISTANCE_CONSIDERED_DELIVERED = 200;

    public DeliveryManUpdateOccupationToFreeListener(DeliveryManService deliveryManService) {
        this.deliveryManService = deliveryManService;
    }

    @Override
    public void coordinateWasCreated(CoordinateDTO coordinateDTO) {
        DeliveryMan deliveryMan = deliveryManService.retrieveById(coordinateDTO.getDeliveryManId());
        Restaurant restaurant = deliveryMan.getRestaurant();
        if(arrivedAtDestination(coordinateDTO, restaurant)) {
            deliveryMan.setOccupation(Occupation.FREE);
            deliveryManService.update(deliveryMan, deliveryMan.getId());
        }
    }

    private boolean arrivedAtDestination(CoordinateDTO coordinateDTO, Restaurant restaurant) {
        return calculateDistanceBetweenPoints(coordinateDTO.getLatitude(), coordinateDTO.getLongitude(),
                restaurant.getLatitude(), restaurant.getLongitude()) < DISTANCE_CONSIDERED_DELIVERED;
    }
}
