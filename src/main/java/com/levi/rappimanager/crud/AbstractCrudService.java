package com.levi.rappimanager.crud;

import java.util.List;

public class AbstractCrudService<T extends IdentifiedEntity> {

    private final AbstractCrudRepository<T> repository;

    public AbstractCrudService(final AbstractCrudRepository<T> repository) {
        this.repository = repository;
    }

    public T retrieveById(Integer id) {
        return repository.findById(id).get();
    }

    public List<T> retrieveAll() {
        return repository.findAll();
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(T entity, Integer id) {
        entity.setId(id);
        return repository.save(entity);
    }

    public void remove(Integer id) {
        repository.deleteById(id);
    }

}
