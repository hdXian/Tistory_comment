package ctoy2work.example.tistorycomment.repository;

import ctoy2work.example.tistorycomment.domain.Comment;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class JpaCommentRepository implements CommentRepository {

    private final EntityManager em;

    public JpaCommentRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Comment add(Comment comment) {
        String addedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        comment.setCommentTime(addedDate);
        em.persist(comment); // 이러면 em이 알아서 DB에 넣어준다. (insert문 자동생성 후 실행)
        return comment;
    }

    @Override
    public Optional<Comment> modify(Comment comment) {
        comment.setCommentTime(LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "(수정됨)");

        em.persist(comment);
        return Optional.ofNullable(comment);

    }

    @Override
    public Optional<Comment> delete(Long id) {
        Comment comment = em.find(Comment.class, id);
        em.remove(comment);
        return Optional.ofNullable(comment);
    }

    @Override
    public Optional<Comment> search(Long id) {
        Comment comment = em.find(Comment.class, id); // 이러면 em이 알아서 찾아준다. (select문 자동생성 후 실행)
        return Optional.ofNullable(comment);
    }

    @Override
    public List<Comment> findAll() {
        return em.createQuery("select c from Comment c", Comment.class)
                .getResultList();
    }
}
