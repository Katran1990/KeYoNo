package com.khripko.dao;

import com.khripko.model.Tag;
import org.springframework.stereotype.Repository;

@Repository
public class TagDaoImpl extends AbstractDao<Tag> {

    public TagDaoImpl(Class<Tag> tagClass) {
        super(tagClass);
    }
}
