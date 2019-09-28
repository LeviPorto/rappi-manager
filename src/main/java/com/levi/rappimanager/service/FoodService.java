package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Food;
import com.levi.rappimanager.dto.FilteredRestaurantDTO;
import com.levi.rappimanager.dto.RestaurantSearchDTO;
import com.levi.rappimanager.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService extends AbstractCrudService<Food> {

    private final FoodRepository repository;
    private final RestaurantService restaurantService;

    public FoodService(final FoodRepository repository, final RestaurantService restaurantService) {
        super(repository);
        this.repository = repository;
        this.restaurantService = restaurantService;
    }

    public List<Food> retrieveFilteredFoods(String searchedName, String userCity) {
        List<FilteredRestaurantDTO> filteredRestaurants = restaurantService.retrieveFilteredRestaurants(RestaurantSearchDTO.builder().userCity(userCity).build());
        List<Food> filteredFoods = new ArrayList<>();

        if (searchedName != null) {
            filteredRestaurants.forEach(restaurant -> restaurant.getFoods().stream()
                    .filter(food -> food.getName().equals(searchedName)).forEach(filteredFoods::add));
        } else {
            filteredRestaurants.forEach(restaurant -> filteredFoods.addAll(restaurant.getFoods()));
        }

        return filteredFoods;
    }

}
