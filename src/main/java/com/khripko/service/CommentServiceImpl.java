package com.khripko.service;

import com.khripko.dao.AttachmentDao;
import com.khripko.dao.CommentDao;
import com.khripko.dao.GenericDao;
import com.khripko.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends GenericServiceImpl<Comment, Long> implements CommentService {

    private CommentDao dao;

    public CommentServiceImpl() {
    }

    @Autowired
    public CommentServiceImpl(@Qualifier("commentDaoImpl")GenericDao<Comment, Long> genericDao) {
        super(genericDao);
        this.dao = (CommentDao) genericDao;
    }
}
