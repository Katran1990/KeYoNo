package com.khripko.dao;

import com.khripko.model.Tag;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TagDaoImpl implements TagDao {

    @Autowired
    SessionFactory sessionFactory;

    public void create(Tag entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public Tag read(Long id) {
        return sessionFactory.getCurrentSession().get(Tag.class, id);
    }

    public Tag update(Tag entity) {
        return (Tag) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(Tag entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
