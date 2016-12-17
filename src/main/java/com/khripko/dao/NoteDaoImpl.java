package com.khripko.dao;

import com.khripko.model.Note;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDaoImpl implements NoteDao {

    @Autowired
    SessionFactory sessionFactory;

    public void create(Note entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public Note read(Long id) {
        return sessionFactory.getCurrentSession().get(Note.class, id);
    }

    public Note update(Note entity) {
        return (Note) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(Note entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
