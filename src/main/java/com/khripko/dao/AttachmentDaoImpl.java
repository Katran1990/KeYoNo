package com.khripko.dao;

import com.khripko.model.Attachment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AttachmentDaoImpl implements AttachmentDao {

    @Autowired
    SessionFactory sessionFactory;

    public void create(Attachment entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public Attachment read(Long id) {
        return sessionFactory.getCurrentSession().get(Attachment.class, id);
    }

    public Attachment update(Attachment entity) {
        return (Attachment) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(Attachment entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
