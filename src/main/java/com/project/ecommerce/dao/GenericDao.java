package com.project.ecommerce.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericDao<T,ID extends Serializable> {

    T saveOrUpdate(T entity);

    Optional<T> getById(ID id);

    List<T> getAll();

    void delete(ID id);
}
