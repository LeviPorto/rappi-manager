package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.DeliveryMan;
import com.levi.rappimanager.domain.enumeration.Occupation;
import com.levi.rappimanager.repository.DeliveryManRepository;
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

}
