package com.project.ecommerce.model.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T,ID> {

    T create(T entity);

    T update(ID id,T t);

    Optional<T> getById(ID id);

    List<T> getAll();

    void delete(ID id);

}
