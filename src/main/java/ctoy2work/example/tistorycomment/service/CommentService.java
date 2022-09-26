package ctoy2work.example.tistorycomment.service;

import ctoy2work.example.tistorycomment.domain.Comment;
import ctoy2work.example.tistorycomment.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

public class CommentService {

    private final CommentRepository commentRepository;

    // DI
    // Constructor
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public Long AddComment(Comment comment) {
        commentRepository.save(comment);
        return comment.getId();
    }

    public List<Comment> getCommentList() {
        return commentRepository.findAll();
    }

    public Optional<Comment> DeleteComment(Comment comment) {
        return commentRepository.deleteById(comment.getId());
    }

    public Optional<Comment> ModifyComment(Long commentId, String newText) {
        Comment res = commentRepository.findById(commentId).get();

        res.setComment(newText);

        return Optional.of(res);
    }

}
