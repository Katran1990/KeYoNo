package com.khripko.service;

import com.khripko.dao.GenericDao;
import com.khripko.dao.NoteDao;
import com.khripko.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl extends GenericServiceImpl<Note, Long> implements NoteService {

    private NoteDao dao;

    public NoteServiceImpl() {
    }

    @Autowired
    public NoteServiceImpl(@Qualifier("noteDaoImpl")GenericDao<Note, Long> genericDao) {
        super(genericDao);
        this.dao = (NoteDao) genericDao;
    }
}
