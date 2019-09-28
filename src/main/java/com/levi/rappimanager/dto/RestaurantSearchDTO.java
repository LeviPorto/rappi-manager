package com.levi.rappimanager.dto;

import com.levi.rappimanager.domain.enumeration.RestaurantCategory;
import com.levi.rappimanager.dto.enumeration.SortSearch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantSearchDTO {

    private Integer deliveryFee;
    private Integer deliveryTime;
    private List<RestaurantCategory> categories;
    private boolean isSuperRestaurant;
    private boolean hasTrackedDelivery;
    private SortSearch sortSearch;
    private Integer userId;
    private String userCity;
    private String searchedName;

}
