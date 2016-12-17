package com.khripko.dao;

import com.khripko.model.UserDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    SessionFactory sessionFactory;

    public void create(UserDetails entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public UserDetails read(Long id) {
        return sessionFactory.getCurrentSession().get(UserDetails.class, id);
    }

    public UserDetails update(UserDetails entity) {
        return (UserDetails) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(UserDetails entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
