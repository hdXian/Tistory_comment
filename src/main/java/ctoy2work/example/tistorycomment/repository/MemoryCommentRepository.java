package ctoy2work.example.tistorycomment.repository;

import ctoy2work.example.tistorycomment.domain.Comment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MemoryCommentRepository implements CommentRepository{

    private static Map<Long, Comment> store = new HashMap<>(); // Comment를 저장할 자료구조
    private static long sequence = 0L;

    // 데이터 추가
    @Override
    public Comment add(Comment comment) { // 댓글 저장시 동작. 내부적으로 사용되는 id값만 설정하여 저장.
        String addedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        comment.setId(++sequence); // id값 설정.
        comment.setCommentTime(addedDate);

        store.put(comment.getId(), comment); // 리포지토리에 comment 저장.
        return comment;
    }

    // 데이터 삭제
    @Override
    public Optional<Comment> delete(Long id) {
        return Optional.ofNullable(store.remove(id));
    }

    // 데이터 검색
    @Override
    public Optional<Comment> search(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 전체 데이터 조회
    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(store.values());
    }

    // 데이터 수정
    @Override
    public Optional<Comment> modify(Comment comment) {
        Comment res = store.put(comment.getId(), comment);
        return Optional.of(res);
    }

    // 저장소 초기화
    public void clearStore() {
        store.clear();
    }
}
