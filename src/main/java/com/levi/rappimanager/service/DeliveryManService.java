package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.DeliveryMan;
import com.levi.rappimanager.domain.enumeration.Occupation;
import com.levi.rappimanager.repository.DeliveryManRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryManService extends AbstractCrudService<DeliveryMan> {

    private final DeliveryManRepository repository;

    public DeliveryManService(DeliveryManRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public DeliveryMan retrieveFirstFreeDeliveryMan(Integer restaurantId) {
        return repository.findTop1ByRestaurantIdAndOccupation(restaurantId, Occupation.FREE);
    }

    public List<DeliveryMan> retrieveByRestaurantAndWaitingAcceptance(Integer restaurantId) {
        return repository.findByRestaurantIdAndOccupation(restaurantId, Occupation.WAITING_ACCEPTANCE);
    }

    public DeliveryMan acceptJob(Integer id) {
        DeliveryMan deliveryMan = repository.findById(id).get();
        deliveryMan.setOccupation(Occupation.IN_WORK);
        return repository.save(deliveryMan);
    }

    @Cacheable(value = "DELIVERY_MAN_BY_ID", key = "{#id}", unless = "#result == null")
    public DeliveryMan retrieveById(Integer id) {
        return repository.findById(id).get();
    }

    public DeliveryMan create(DeliveryMan deliveryMan) {
        return repository.save(deliveryMan);
    }

    @Caching(evict = @CacheEvict(value = "RATING_BY_RESTAURANT_ID_", key = "{#deliveryMan.id}"))
    public DeliveryMan update(DeliveryMan deliveryMan, Integer id) {
        deliveryMan.setId(id);
        return repository.save(deliveryMan);
    }

}
