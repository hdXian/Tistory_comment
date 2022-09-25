package ctoy2work.example.tistorycomment.repository;

import ctoy2work.example.tistorycomment.domain.Comment;

import java.time.LocalDateTime;
import java.util.*;

public class MemoryCommentRepository implements CommentRepository{

    private static Map<Long, Comment> store = new HashMap<>(); // Comment를 저장할 자료구조
    private static long sequence = 0L;

    @Override
    public Comment save(Comment comment) { // 댓글 저장시 동작. 내부적으로 사용되는 id값만 설정하여 저장.
        comment.setId(++sequence); // id값 설정.
        store.put(comment.getId(), comment); // 리포지토리에 comment 저장.
        return comment;
    }

    @Override
    public Optional<Comment> deleteById(Long id) {
        return Optional.ofNullable(store.remove(id));
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
