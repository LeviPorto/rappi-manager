package com.levi.rappimanager.filter;

import com.levi.rappimanager.dto.FilteredRestaurantDTO;
import com.levi.rappimanager.dto.RestaurantSearchDTO;

import java.util.List;

public interface RestaurantFilter {

    List<FilteredRestaurantDTO> filterRestaurant(RestaurantSearchDTO restaurantSearchDTO, List<FilteredRestaurantDTO> userCityRestaurants);

}
