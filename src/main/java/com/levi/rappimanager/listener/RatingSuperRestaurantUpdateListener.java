package com.levi.rappimanager.listener;

import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.dto.EvaluatedRestaurantDTO;
import com.levi.rappimanager.service.RestaurantService;
import org.springframework.stereotype.Component;

@Component
public class RatingSuperRestaurantUpdateListener implements RatingUpdateListener {

    private final RestaurantService restaurantService;

    public RatingSuperRestaurantUpdateListener(final RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void ratingWasUpdated(EvaluatedRestaurantDTO evaluatedRestaurantDTO, Restaurant restaurant) {
        restaurant.setIsSuperRestaurant(evaluatedRestaurantDTO.isSuperRestaurant());
        restaurantService.create(restaurant);
    }

}
