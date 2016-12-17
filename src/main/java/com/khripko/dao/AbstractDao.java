package com.khripko.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class AbstractDao<T> {

    private final Class<T> tClass;

    public AbstractDao(Class<T> tClass){
        this.tClass = tClass;
    }

    @Autowired
    SessionFactory sessionFactory;

    void create(T entity){
        sessionFactory.getCurrentSession().persist(entity);
    }

    T read(Long id){
        return sessionFactory.getCurrentSession().get(tClass, id);
    }

    T update(T entity){
        return (T) sessionFactory.getCurrentSession().merge(entity);
    }

    void delete(T entity){
        sessionFactory.getCurrentSession().delete(entity);
    }

}
