package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.ComboItem;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboItemRepository extends AbstractCrudRepository<ComboItem> {}
