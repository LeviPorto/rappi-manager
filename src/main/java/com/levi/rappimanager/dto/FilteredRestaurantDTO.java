package com.levi.rappimanager.dto;

import com.levi.rappimanager.domain.Combo;
import com.levi.rappimanager.domain.Food;
import com.levi.rappimanager.domain.Promotion;
import com.levi.rappimanager.domain.enumeration.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FilteredRestaurantDTO {

    public RestaurantCategory restaurantCategory;
    public Integer restaurantId;
    private boolean isIFoodDelivery;
    private boolean isSuperRestaurant;
    private boolean hasTrackedDelivery;
    private Double distanceFromCustomer;
    private Double deliveryFee;
    private Double deliveryTime;
    private List<Food> foods;
    private List<Combo> combos;
    private List<Promotion> promotions;

}
