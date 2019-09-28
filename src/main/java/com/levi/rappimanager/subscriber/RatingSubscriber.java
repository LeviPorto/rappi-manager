package com.levi.rappimanager.subscriber;

import com.levi.rappimanager.dispatcher.RatingDispatcher;
import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.dto.EvaluatedRestaurantDTO;
import com.levi.rappimanager.service.RestaurantService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RatingSubscriber {

    private final RatingDispatcher ratingDispatcher;
    private final RestaurantService restaurantService;

    public RatingSubscriber(final RatingDispatcher ratingDispatcher, final RestaurantService restaurantService) {
        this.ratingDispatcher = ratingDispatcher;
        this.restaurantService = restaurantService;
    }

    @KafkaListener(topics = "RATING_EVENT_SOURCING", groupId = "1234", containerFactory = "kafkaListenerContainerFactory")
    public void processRatingEventSourcing(@Payload EvaluatedRestaurantDTO evaluatedRestaurantDTO) {
        Restaurant restaurant = restaurantService.retrieveById(evaluatedRestaurantDTO.getRestaurantId());
        ratingDispatcher.notifyUpdateRatingListeners(evaluatedRestaurantDTO, restaurant);
    }

}
