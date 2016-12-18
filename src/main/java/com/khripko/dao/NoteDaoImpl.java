package com.khripko.dao;

import com.khripko.model.Note;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDaoImpl extends GenericDaoImpl<Note, Long> implements NoteDao {

}
