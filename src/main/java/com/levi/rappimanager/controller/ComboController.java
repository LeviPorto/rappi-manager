package com.levi.rappimanager.controller;

import com.levi.rappimanager.crud.AbstractCrudController;
import com.levi.rappimanager.domain.Combo;
import com.levi.rappimanager.service.ComboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/combo")
public class ComboController extends AbstractCrudController<Combo> {

    private final ComboService service;

    public ComboController(final ComboService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/search")
    public List<Combo> getFilteredCombos(@RequestParam String searchedName, @RequestParam String userCity) {
        return service.retrieveFilteredCombos(searchedName, userCity);
    }

}
