package com.project.ecommerce.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {
}
