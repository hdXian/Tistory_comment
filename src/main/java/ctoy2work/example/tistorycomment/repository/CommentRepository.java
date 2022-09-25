package ctoy2work.example.tistorycomment.repository;

import ctoy2work.example.tistorycomment.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment); // 리포지토리에 Comment 저장
    Optional<Comment> deleteById(Long id); // Comment 삭제 (id로 찾아 삭제할 예정)
    Optional<Comment> findById(Long id); // Comment 수정 (id로 찾아 수정할 예정)
    List<Comment> findAll(); // 리포지토리의 모든 Comment를 List로 담아 반환.

}
