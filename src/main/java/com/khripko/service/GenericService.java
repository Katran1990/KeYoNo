package com.khripko.service;

import java.util.List;

public interface GenericService<E, K> {
    void create(E entity);
    E read(K id);
    List<E> readAll();
    E update(E entity);
    void delete(E entity);
}
