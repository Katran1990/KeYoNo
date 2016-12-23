package com.khripko.dao;


import com.khripko.service.GenericServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {

    protected Class<? extends E> type;

    @Autowired
    private SessionFactory sessionFactory;

    public GenericDaoImpl(){
        Type t = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<? extends E>) pt.getActualTypeArguments()[0];
    }

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void create(E entity) {
        currentSession().persist(entity);
    }

    public E read(K id) {
        return currentSession().get(type, id);
    }

    public List<E> readAll() {
        return (List<E>) currentSession().createQuery("from "+type.getSimpleName()).list();
    }

    public E update(E entity) {
        return (E) currentSession().merge(entity);
    }

    public void delete(E entity) {
        currentSession().delete(entity);
    }
}
