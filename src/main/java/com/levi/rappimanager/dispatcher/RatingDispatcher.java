package com.levi.rappimanager.dispatcher;

import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.dto.EvaluatedRestaurantDTO;
import com.levi.rappimanager.listener.RatingUpdateListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RatingDispatcher {

    private final List<RatingUpdateListener> updateRatingListeners;

    @Autowired
    public RatingDispatcher(List<RatingUpdateListener> updateRatingListeners) {
        this.updateRatingListeners = updateRatingListeners;
    }

    public void notifyUpdateRatingListeners(final EvaluatedRestaurantDTO evaluatedRestaurantDTO, final Restaurant restaurant) {
        if (updateRatingListeners != null) {
            for (RatingUpdateListener listener : updateRatingListeners) {
                listener.ratingWasUpdated(evaluatedRestaurantDTO, restaurant);
            }
        }
    }

}
