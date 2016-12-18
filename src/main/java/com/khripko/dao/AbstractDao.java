package com.khripko.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class AbstractDao<T> {

    private final Class<T> tClass;

    @Autowired
    private SessionFactory sessionFactory;

    public AbstractDao(Class<T> tClass){
        this.tClass = tClass;
    }

    public void create(T entity){
        sessionFactory.getCurrentSession().persist(entity);
    }

    public T read(Long id){
        return sessionFactory.getCurrentSession().get(tClass, id);
    }

    public List<T> readAll(){
        return (List<T>)sessionFactory.getCurrentSession().createQuery("from "+ tClass).list();
    }

    public T update(T entity){
        return (T) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(T entity){
        sessionFactory.getCurrentSession().delete(entity);
    }

}
