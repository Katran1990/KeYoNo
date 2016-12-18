package com.khripko.dao;


import com.khripko.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl extends GenericDaoImpl<Comment, Long> implements CommentDao {
}
