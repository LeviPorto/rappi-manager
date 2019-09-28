package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractCrudRepository<User> {
}
