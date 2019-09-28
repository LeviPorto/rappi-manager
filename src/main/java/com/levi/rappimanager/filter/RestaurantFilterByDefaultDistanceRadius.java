package com.levi.rappimanager.filter;

import com.levi.rappimanager.dto.FilteredRestaurantDTO;
import com.levi.rappimanager.dto.RestaurantSearchDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.levi.rappimanager.service.DistanceCalculatorService.DEFAULT_DELIVERY_RADIUS_IN_METERS;

@Component
public class RestaurantFilterByDefaultDistanceRadius implements RestaurantFilter {

    @Override
    public List<FilteredRestaurantDTO> filterRestaurant(RestaurantSearchDTO restaurantSearchDTO, List<FilteredRestaurantDTO> userCityRestaurants) {
        return userCityRestaurants.stream().filter(userCityRestaurant -> userCityRestaurant.getDistanceFromCustomer() < DEFAULT_DELIVERY_RADIUS_IN_METERS).collect(Collectors.toList());
    }

}
