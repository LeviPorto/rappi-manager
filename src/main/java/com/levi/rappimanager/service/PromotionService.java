package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Promotion;
import com.levi.rappimanager.dto.FilteredRestaurantDTO;
import com.levi.rappimanager.dto.RestaurantSearchDTO;
import com.levi.rappimanager.dto.enumeration.SortSearch;
import com.levi.rappimanager.repository.PromotionRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionService extends AbstractCrudService<Promotion> {

    private final PromotionRepository repository;
    private final RestaurantService restaurantService;

    public PromotionService(final PromotionRepository repository, final RestaurantService restaurantService) {
        super(repository);
        this.repository = repository;
        this.restaurantService = restaurantService;
    }

    public List<Promotion> retrieveFilteredPromotions(String searchedName, String userCity, Integer userId) {
        List<FilteredRestaurantDTO> filteredRestaurants = restaurantService.retrieveFilteredRestaurants(RestaurantSearchDTO
                .builder().userCity(userCity).sortSearch(SortSearch.DEFAULT).userId(userId).build());
        List<Promotion> filteredPromotions = new ArrayList<>();

        if (searchedName != null) {
            filteredRestaurants.forEach(restaurant -> {
                List<Promotion> promotions = restaurant.getPromotions();
                if(!CollectionUtils.isEmpty(promotions)) {
                    promotions.stream().filter(promotion -> promotion.getName().equals(searchedName)).forEach(filteredPromotions::add);
                }
            });
        } else {
            filteredRestaurants.forEach(restaurant -> filteredPromotions.addAll(restaurant.getPromotions()));
        }

        return filteredPromotions;
    }

    public List<Promotion> retrieveByRestaurant(Integer restaurantId) {
        return repository.findByRestaurantId(restaurantId);
    }
}
