package com.khripko.dao;

import com.khripko.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl extends AbstractDao<Comment> {

    public CommentDaoImpl(Class<Comment> commentClass) {
        super(commentClass);
    }
}
