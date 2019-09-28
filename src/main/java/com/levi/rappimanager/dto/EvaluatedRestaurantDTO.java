package com.levi.rappimanager.dto;

import lombok.Data;

@Data
public class EvaluatedRestaurantDTO {

    private Integer restaurantId;
    private Double rating;
    private boolean isSuperRestaurant;

}
