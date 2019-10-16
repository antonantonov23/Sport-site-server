package com.nbu.sportapp.nbusportapp.dao;

import java.util.List;

import com.nbu.sportapp.nbusportapp.entity.event.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbu.sportapp.nbusportapp.repository.CommentRepository;

// DATA ACCESS OBJECT
@Service
public class CommentDAO {

    @Autowired
    private CommentRepository commentRepository;

    /* to save an comment in DB */

    public Comment save(Comment comment) {
        return this.commentRepository.save(comment);
    }

    /* search all comments */

    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    /* get an comment */

    public Comment findOne(Long commentId) {
        return this.commentRepository.findOne(commentId);
    }

    /* delete an comment */

    public void delete(Comment comment) {
        this.commentRepository.delete(comment);
    }
}
