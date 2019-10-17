package com.nbu.sportapp.nbusportapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.nbu.sportapp.nbusportapp.dao.AccountDAO;
import com.nbu.sportapp.nbusportapp.dao.BaseEventDAO;
import com.nbu.sportapp.nbusportapp.entity.account.Account;
import com.nbu.sportapp.nbusportapp.entity.event.BaseEvent;
import com.nbu.sportapp.nbusportapp.entity.event.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nbu.sportapp.nbusportapp.dao.CommentDAO;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping("/sportapp")
public class CommentController {

    @Autowired
    CommentDAO commentDAO;

    @Autowired
    BaseEventDAO baseEventDAO;

    @Autowired
    AccountDAO accountDAO;

    /* to save an comment */
    @PostMapping("/comment")
    public Comment createComment(@RequestBody Comment comment) {

        Account publisher = this.accountDAO.findOne(comment.getAccountId());
        BaseEvent baseEvent = this.baseEventDAO.findOne(comment.getBaseEventId());

        Comment currentComment = new Comment();
        currentComment.setAccountId(publisher.getId());
        currentComment.setAccount(publisher);
        currentComment.setBaseEventId(baseEvent.getId());
        currentComment.setBaseEvent(baseEvent);
        currentComment.setPublisherName(publisher.getFullName());
        currentComment.setBodyOfComment(comment.getBodyOfComment());

        return this.commentDAO.save(currentComment);
    }

    /* get all comments */
    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return this.commentDAO.findAll();
    }

    /* get an comment by ID */
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "id") Long commentId) {
        Comment comment = this.commentDAO.findOne(commentId);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(comment);
    }

    /* update an comment */
    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable(value = "id") Long commentId,
                                                 @Valid @RequestBody Comment commentDetails) {
        Comment comment = this.commentDAO.findOne(commentId);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }

        Comment updateComment = this.commentDAO.save(comment);
        return ResponseEntity.ok().body(updateComment);

    }

    /* delete an comment */
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable(value = "id") Long commentId) {

        Comment comment = this.commentDAO.findOne(commentId);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        this.commentDAO.delete(comment);

        return ResponseEntity.ok().build();
    }

}