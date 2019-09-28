package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/user")
public class UserController extends AbstractCrudService<User> {

    public UserController(AbstractCrudRepository<User> repository) {
        super(repository);
    }

}
