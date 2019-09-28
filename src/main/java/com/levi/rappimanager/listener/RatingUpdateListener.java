package com.levi.rappimanager.listener;

import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.dto.EvaluatedRestaurantDTO;

public interface RatingUpdateListener {

    void ratingWasUpdated(EvaluatedRestaurantDTO evaluatedRestaurantDTO, Restaurant restaurant);

}
