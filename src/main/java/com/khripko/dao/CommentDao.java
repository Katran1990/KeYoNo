package com.khripko.dao;

import com.khripko.model.Comment;

public interface CommentDao {

    void create(Comment entity);
    Comment read(Long id);
    Comment update(Comment entity);
    void delete(Comment entity);

}
