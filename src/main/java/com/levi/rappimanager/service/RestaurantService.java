package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.dao.RestaurantDao;
import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.dto.FilteredRestaurantDTO;
import com.levi.rappimanager.dto.RestaurantSearchDTO;
import com.levi.rappimanager.dto.enumeration.SortSearch;
import com.levi.rappimanager.filter.RestaurantFilter;
import com.levi.rappimanager.repository.RestaurantRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService extends AbstractCrudService<Restaurant> {

    private final RestaurantDao dao;
    private final RestaurantRepository repository;
    private final DistanceCalculatorService distanceCalculatorService;
    private final List<RestaurantFilter> restaurantFilters;

    public RestaurantService(final RestaurantDao dao, final RestaurantRepository repository,
                             final DistanceCalculatorService distanceCalculatorService, List<RestaurantFilter> restaurantFilters) {
        super(repository);
        this.dao = dao;
        this.repository = repository;
        this.distanceCalculatorService = distanceCalculatorService;
        this.restaurantFilters = restaurantFilters;
    }

    @Caching(evict = @CacheEvict(value = "FILTERED_RESTAURANT_BY_USER_CITY", key = "{#restaurant.city}"))
    public Restaurant create(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Caching(evict = {@CacheEvict(value = "FILTERED_RESTAURANT_BY_USER_CITY", key = "{#restaurant.city}"),
            @CacheEvict(value = "RESTAURANT_BY_ID", key = "{#restaurant.id}")})
    public Restaurant update(Restaurant restaurant, Integer id) {
        restaurant.setId(id);
        return repository.save(restaurant);
    }

    @Cacheable(value = "RESTAURANT_BY_ID", key = "{#id}", unless = "#result == null")
    public Restaurant retrieveById(Integer id) {
        return repository.findById(id).get();
    }

    public List<FilteredRestaurantDTO> retrieveFilteredRestaurants(RestaurantSearchDTO restaurantSearchDTO) {
        List<FilteredRestaurantDTO> userCityRestaurants = retrieveUserCityRestaurants(restaurantSearchDTO);

        fillFilteredRestaurantsWithDeliveryFee(restaurantSearchDTO.getUserId(), userCityRestaurants);
        fillFilteredRestaurantsWithDeliveryTime(restaurantSearchDTO.getUserId(), userCityRestaurants);
        fillFilteredRestaurantsWithDeliveryDistance(restaurantSearchDTO.getUserId(), userCityRestaurants);

        for (RestaurantFilter restaurantFilter : restaurantFilters) {
            userCityRestaurants = restaurantFilter.filterRestaurant(restaurantSearchDTO, userCityRestaurants);
        }

        return sortFilteredRestaurants(userCityRestaurants, restaurantSearchDTO.getSortSearch());
    }

    public Restaurant retrieveByDeliveryMan(Integer deliveryManId) {
        return repository.findByDeliveryManId(deliveryManId);
    }

    @Cacheable(value = "FILTERED_RESTAURANT_BY_USER_CITY", key = "{#restaurantSearchDTO.userCity}", unless = "#result == null || #result.isEmpty()")
    public List<FilteredRestaurantDTO> retrieveUserCityRestaurants(RestaurantSearchDTO restaurantSearchDTO) {
        return dao.findUserCityRestaurants(restaurantSearchDTO);
    }

    private List<FilteredRestaurantDTO> sortFilteredRestaurants(List<FilteredRestaurantDTO> userCityRestaurants, SortSearch sortSearch) {
        switch (sortSearch) {
            case SHORTEST_DELIVERY_FEE:
                return userCityRestaurants.stream().sorted(Comparator.comparingDouble(FilteredRestaurantDTO::getDeliveryFee)).collect(Collectors.toList());
            case SHORTEST_DISTANCE:
                return userCityRestaurants.stream().sorted(Comparator.comparingDouble(FilteredRestaurantDTO::getDistanceFromCustomer)).collect(Collectors.toList());
            case SHORTEST_DELIVERY_TIME:
                return userCityRestaurants.stream().sorted(Comparator.comparingDouble(FilteredRestaurantDTO::getDeliveryTime)).collect(Collectors.toList());
            case SHORTEST_DELIVERY_PRICE:
                return userCityRestaurants.stream().sorted(Comparator.comparingDouble(restaurant -> repository.findById(restaurant.getRestaurantId()).get().getCost())).collect(Collectors.toList());
            case DEFAULT:
                return userCityRestaurants;
        }
        return userCityRestaurants;
    }

    private void fillFilteredRestaurantsWithDeliveryFee(Integer userId, List<FilteredRestaurantDTO> userCityRestaurants) {
        userCityRestaurants.forEach(userCityRestaurant -> {
            Double deliveryFee = distanceCalculatorService.calculateRestaurantDeliveryFeeBasedOnDistance(userId, userCityRestaurant.getRestaurantId(), userCityRestaurant);
            userCityRestaurant.setDeliveryFee(deliveryFee);
        });
    }

    private void fillFilteredRestaurantsWithDeliveryTime(Integer userId, List<FilteredRestaurantDTO> userCityRestaurants) {
        userCityRestaurants.forEach(userCityRestaurant -> {
            Double deliveryFee = distanceCalculatorService.calculateRestaurantDeliveryTimeBasedOnDistance(userId, userCityRestaurant.getRestaurantId(), userCityRestaurant);
            userCityRestaurant.setDeliveryTime(deliveryFee);
        });
    }

    private void fillFilteredRestaurantsWithDeliveryDistance(Integer userId, List<FilteredRestaurantDTO> userCityRestaurants) {
        userCityRestaurants.forEach(userCityRestaurant -> {
            Double deliveryFee = distanceCalculatorService.calculateRestaurantDefaultDeliveryRadius(userId, userCityRestaurant.getRestaurantId(), userCityRestaurant);
            userCityRestaurant.setDistanceFromCustomer(deliveryFee);
        });
    }
}
