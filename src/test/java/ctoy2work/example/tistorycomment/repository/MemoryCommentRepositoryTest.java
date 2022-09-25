package ctoy2work.example.tistorycomment.repository;

import ctoy2work.example.tistorycomment.domain.Comment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;


class MemoryCommentRepositoryTest {

    MemoryCommentRepository commentRepository = new MemoryCommentRepository();

    @Test
    void save() {

        // given
        Comment comment = new Comment();
        comment.setNickname("test1");
        comment.setPassword("123");
        comment.setComment("hello world!");
        comment.setCommentTime(LocalDateTime.now());

        // when
        commentRepository.save(comment);

        // then
        Comment res = commentRepository.findById(comment.getId()).get();

        Assertions.assertThat(res).isEqualTo(comment);
        
    }

    @Test
    void deleteById() {

        // given
        Comment comment = new Comment();
        comment.setNickname("test1");
        comment.setPassword("123");
        comment.setComment("hello world!");
        comment.setCommentTime(LocalDateTime.now());

        // when
        commentRepository.save(comment);
        commentRepository.deleteById(comment.getId());

        // then
        Assertions.assertThat(commentRepository.findById(comment.getId()).isPresent()).isFalse();

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}