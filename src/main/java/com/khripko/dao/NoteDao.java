package com.khripko.dao;

import com.khripko.model.Note;

public interface NoteDao {

    void create(Note entity);
    Note read(Long id);
    Note update(Long id);
    void delete(Long id);

}
