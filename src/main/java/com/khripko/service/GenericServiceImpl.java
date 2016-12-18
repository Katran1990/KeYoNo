package com.khripko.service;

import com.khripko.dao.GenericDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class GenericServiceImpl<E, K> implements GenericService<E, K>{

    private GenericDao<E, K> genericDao;

    public GenericServiceImpl() {
    }

    public GenericServiceImpl(GenericDao<E, K> genericDao){
        this.genericDao = genericDao;
    }

    @Transactional
    public void create(E entity) {
        genericDao.create(entity);
    }

    @Transactional(readOnly = true)
    public E read(K id) {
        return genericDao.read(id);
    }

    @Transactional(readOnly = true)
    public List<E> readAll() {
        return genericDao.readAll();
    }

    @Transactional
    public E update(E entity) {
        return genericDao.update(entity);
    }

    @Transactional
    public void delete(E entity) {
        genericDao.delete(entity);
    }
}
