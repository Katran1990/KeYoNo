package com.khripko.dao;

import com.khripko.model.Rate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RateDaoImpl implements RateDao {

    @Autowired
    SessionFactory sessionFactory;

    public void create(Rate entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public Rate read(Long id) {
        return sessionFactory.getCurrentSession().get(Rate.class, id);
    }

    public Rate update(Rate entity) {
        return (Rate) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(Rate entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
