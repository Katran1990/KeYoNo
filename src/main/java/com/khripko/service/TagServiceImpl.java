package com.khripko.service;

import com.khripko.dao.GenericDao;
import com.khripko.dao.TagDao;
import com.khripko.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends GenericServiceImpl<Tag, Long> implements TagService {

    private TagDao dao;

    public TagServiceImpl() {
    }

    @Autowired
    public TagServiceImpl(@Qualifier("tagDaoImpl")GenericDao<Tag, Long> genericDao) {
        super(genericDao);
        this.dao = (TagDao) genericDao;
    }
}
