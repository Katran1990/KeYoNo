package com.khripko.service;

import com.khripko.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class AbstractService<T> {

    @Autowired
    AbstractDao<T> dao;

    @Transactional
    public void create(T entity){
        dao.create(entity);
    }

    @Transactional
    public T read(Long id){
        return dao.read(id);
    }

    @Transactional
    public List<T> readAll(){
        return dao.readAll();
    }

    @Transactional
    public T update(T entity){
        return dao.update(entity);
    }

    @Transactional
    public void delete(T entity){
        dao.delete(entity);
    }

}
