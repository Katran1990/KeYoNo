package com.khripko.dao;

import java.util.List;

public interface GenericDao<E, K> {
    void create(E entity);
    E read(K id);
    List<E> readAll();
    E update(E entity);
    void delete(E entity);
}
