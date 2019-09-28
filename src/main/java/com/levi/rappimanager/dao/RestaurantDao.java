package com.levi.rappimanager.dao;

import com.levi.rappimanager.domain.Restaurant;
import com.levi.rappimanager.dto.FilteredRestaurantDTO;
import com.levi.rappimanager.dto.RestaurantSearchDTO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class RestaurantDao {

    private EntityManager entityManager;
    private Session session;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private CriteriaQuery<Restaurant> getCriteriaQuery() {
        if (entityManager == null || (session = entityManager.unwrap(Session.class)) == null) {
            throw new NullPointerException();
        }
        return session.getCriteriaBuilder().createQuery(Restaurant.class);
    }

    private CriteriaBuilder getCriteriaBuilder() {
        return session.getCriteriaBuilder();
    }

    public List<FilteredRestaurantDTO> findUserCityRestaurants(RestaurantSearchDTO restaurantSearchDTO) {
        CriteriaQuery<Restaurant> criteria = getCriteriaQuery();
        Root<Restaurant> root = criteria.from(Restaurant.class);

        criteria.multiselect(root.get("id"), root.get("name"), root.get("category"), root.get("cost"), root.get("latitude"), root.get("longitude"),
                root.get("rating"), root.get("isIFoodDelivery"), root.get("isSuperRestaurant"), root.get("hasTrackedDelivery"))
                .where(getCriteriaBuilder().equal(root.get("city"), restaurantSearchDTO.getUserCity()));

        if (restaurantSearchDTO.getSearchedName() != null) {
            criteria.where(getCriteriaBuilder().like(root.get("name"), "%" + restaurantSearchDTO.getSearchedName() + "%"));
        }

        List<Restaurant> restaurants = session.createQuery(criteria).getResultList();

        return restaurants.stream().map(restaurant -> new FilteredRestaurantDTO(restaurant.getCategory(),
                restaurant.getId(), restaurant.getIsIFoodDelivery(), restaurant.getIsSuperRestaurant(),
                restaurant.getHasTrackedDelivery(), null, null,
                null, null, null, null)).collect(Collectors.toList());
    }

}
