package com.khripko.dao;

import com.khripko.model.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    SessionFactory sessionFactory;

    public void create(Comment entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public Comment read(Long id) {
        return sessionFactory.getCurrentSession().get(Comment.class, id);
    }

    public Comment update(Comment entity) {
        return (Comment) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(Comment entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
