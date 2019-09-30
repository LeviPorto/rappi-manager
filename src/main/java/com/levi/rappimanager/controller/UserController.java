package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.User;
import com.levi.rappimanager.service.RestaurantService;
import com.levi.rappimanager.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/user")
public class UserController extends AbstractCrudController<User> {

    private final UserService service;

    public UserController(final UserService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/findByIds")
    public List<User> getUserByIds(@RequestParam("ids") List<Integer> ids) {
        return service.retrieveByIds(ids);
    }
}
