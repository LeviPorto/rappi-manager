package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.Combo;
import com.levi.rappimanager.dto.FilteredRestaurantDTO;
import com.levi.rappimanager.dto.RestaurantSearchDTO;
import com.levi.rappimanager.dto.enumeration.SortSearch;
import com.levi.rappimanager.repository.ComboRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComboService extends AbstractCrudService<Combo> {

    private final ComboRepository repository;
    private final RestaurantService restaurantService;

    public ComboService(final ComboRepository repository, final RestaurantService restaurantService) {
        super(repository);
        this.repository = repository;
        this.restaurantService = restaurantService;
    }

    public List<Combo> retrieveFilteredCombos(String searchedName, String userCity, Integer userId) {
        List<FilteredRestaurantDTO> filteredRestaurants = restaurantService.retrieveFilteredRestaurants(RestaurantSearchDTO
                .builder().userCity(userCity).sortSearch(SortSearch.DEFAULT).userId(userId).build());
        List<Combo> filteredCombos = new ArrayList<>();

        if (searchedName != null) {
            filteredRestaurants.forEach(restaurant -> {
                List<Combo> combos = restaurant.getCombos();
                if(!CollectionUtils.isEmpty(combos)) {
                    combos.stream().filter(combo -> combo.getName().equals(searchedName)).forEach(filteredCombos::add);
                }
            });
        } else {
            filteredRestaurants.forEach(restaurant -> filteredCombos.addAll(restaurant.getCombos()));
        }

        return filteredCombos;
    }

    public List<Combo> retrieveByRestaurant(Integer restaurantId) {
        return repository.findByRestaurantId(restaurantId);
    }

}
