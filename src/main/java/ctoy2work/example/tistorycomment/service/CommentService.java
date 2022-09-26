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


    // 댓글 추가
    public Long AddComment(Comment comment) {
        commentRepository.add(comment);
        return comment.getId();
    }

    // 댓글 목록 불러오기
    public List<Comment> getCommentList() {
        return commentRepository.findAll();
    }

    // 댓글 삭제
    public Optional<Comment> DeleteComment(Comment comment) {
        return commentRepository.delete(comment.getId());
    }

    // 댓글 수정
    public Optional<Comment> ModifyComment(Long commentId, String newText) {
        Comment modifiedComment = commentRepository.search(commentId).get();

        modifiedComment.setComment(newText);

        return commentRepository.modify(modifiedComment);
    }

}
