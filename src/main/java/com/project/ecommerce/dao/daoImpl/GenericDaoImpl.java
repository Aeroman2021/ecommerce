package com.project.ecommerce.dao.daoImpl;

import com.project.ecommerce.dao.GenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class GenericDaoImpl <T, ID extends Serializable> implements GenericDao<T,ID> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T saveOrUpdate(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Optional<T> getById(ID id) {
        return Optional.ofNullable(entityManager.find(entityClass,id));
    }

    @Override
    public List<T> getAll() {
        return entityManager.createQuery(" from " + entityClass.getName(),entityClass)
                .getResultList();
    }

    @Override
    public void delete(ID id) {
        getById(id).ifPresent(entityManager::remove);
    }
}
