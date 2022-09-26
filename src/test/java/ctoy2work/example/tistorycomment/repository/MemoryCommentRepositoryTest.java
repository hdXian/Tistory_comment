package ctoy2work.example.tistorycomment.repository;

import ctoy2work.example.tistorycomment.domain.Comment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


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
        commentRepository.add(comment);

        // then
        Comment res = commentRepository.search(comment.getId()).get();

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
        commentRepository.add(comment);
        commentRepository.delete(comment.getId());

        // then
        Assertions.assertThat(commentRepository.search(comment.getId()).isPresent()).isFalse();

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}