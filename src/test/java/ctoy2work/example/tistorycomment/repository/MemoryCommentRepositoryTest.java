package ctoy2work.example.tistorycomment.repository;

import ctoy2work.example.tistorycomment.domain.Comment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class MemoryCommentRepositoryTest {

    MemoryCommentRepository commentRepository = new MemoryCommentRepository();

    @Test
    void save() {

        // given
        Comment comment = new Comment();
        comment.setNickname("test1");
        comment.setPassword("123");
        comment.setCommentText("hello world!");
        String savedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        comment.setCommentTime(savedDate);

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
        comment.setCommentText("hello world!");
        comment.setCommentTime(LocalDateTime.now().toString());

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