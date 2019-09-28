package com.levi.rappimanager.service;

import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.domain.User;
import com.levi.rappimanager.dto.FilteredRestaurantDTO;
import com.levi.rappimanager.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import static com.levi.rappimanager.util.DistanceCalculatorUtil.calculateDistanceBetweenPoints;

@Service
public class DistanceCalculatorService {

    private final UserService userService;
    private final RestaurantRepository restaurantRepository;

    private final static Double NORMAL_SPEED_M_PER_SECONDS = 8.33;
    public final static Double DEFAULT_DELIVERY_RADIUS_IN_METERS = 2000.0;

    public DistanceCalculatorService(final UserService userService, final RestaurantRepository restaurantRepository) {
        this.userService = userService;
        this.restaurantRepository = restaurantRepository;
    }

    public Double calculateRestaurantDefaultDeliveryRadius(Integer userId, Integer restaurantId, FilteredRestaurantDTO filteredRestaurantDTO) {
        User user = userService.retrieveById(userId);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Double calculatedDistanceFromRestaurantToCustomer = calculateDistanceBetweenPoints(user.getLatitude(), user.getLongitude(), restaurant.getLatitude(), restaurant.getLongitude());
        filteredRestaurantDTO.setDistanceFromCustomer(calculatedDistanceFromRestaurantToCustomer);

        return calculatedDistanceFromRestaurantToCustomer;
    }

    public Double calculateRestaurantDeliveryFeeBasedOnDistance(Integer userId, Integer restaurantId, FilteredRestaurantDTO filteredRestaurantDTO) {
        User user = userService.retrieveById(userId);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Double distanceFromUserToRestaurant = calculateDistanceBetweenPoints(user.getLatitude(), user.getLongitude(), restaurant.getLatitude(), restaurant.getLongitude());
        Double restaurantDeliveryFee = distanceFromUserToRestaurant * restaurant.getDeliveryFee();

        filteredRestaurantDTO.setDeliveryFee(restaurantDeliveryFee);

        return restaurantDeliveryFee;
    }

    public Double calculateRestaurantDeliveryTimeBasedOnDistance(Integer userId, Integer restaurantId, FilteredRestaurantDTO filteredRestaurantDTO) {
        User user = userService.retrieveById(userId);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Double distanceFromUserToRestaurant = calculateDistanceBetweenPoints(user.getLatitude(), user.getLongitude(), restaurant.getLatitude(), restaurant.getLongitude());
        Double restaurantDeliveryTime = distanceFromUserToRestaurant / NORMAL_SPEED_M_PER_SECONDS;

        filteredRestaurantDTO.setDeliveryTime(restaurantDeliveryTime);

        return restaurantDeliveryTime;
    }

}
