package ctoy2work.example.tistorycomment.controller;

import ctoy2work.example.tistorycomment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// @Controller
public class CommentController {

    // @Autowired
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
}
