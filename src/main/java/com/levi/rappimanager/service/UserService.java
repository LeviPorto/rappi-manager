package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<User> {

    public UserService(AbstractCrudRepository<User> repository) {
        super(repository);
    }

}
