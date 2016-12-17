package com.khripko.dao;

import com.khripko.model.Tag;

public interface TagDao {

    void create(Tag entity);
    Tag read(Long id);
    Tag update(Long id);
    void delete(Long id);

}
