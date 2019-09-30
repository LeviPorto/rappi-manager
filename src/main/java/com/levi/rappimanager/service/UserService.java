package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.User;
import com.levi.rappimanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractCrudService<User> {

    private final UserRepository repository;

    public UserService(final UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<User> retrieveByIds(List<Integer> ids) {
        return repository.findByIdIn(ids);
    }

}
