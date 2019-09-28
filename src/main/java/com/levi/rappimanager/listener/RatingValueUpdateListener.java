package com.levi.rappimanager.listener;

import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.dto.EvaluatedRestaurantDTO;
import com.levi.rappimanager.service.RestaurantService;
import org.springframework.stereotype.Component;

@Component
public class RatingValueUpdateListener implements RatingUpdateListener {

    private final RestaurantService restaurantService;

    public RatingValueUpdateListener(final RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void ratingWasUpdated(EvaluatedRestaurantDTO evaluatedRestaurantDTO, Restaurant restaurant) {
        restaurant.setRating(evaluatedRestaurantDTO.getRating());
        restaurantService.create(restaurant);
    }

}
