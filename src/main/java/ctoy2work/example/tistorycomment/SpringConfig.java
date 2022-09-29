package ctoy2work.example.tistorycomment;

import ctoy2work.example.tistorycomment.repository.CommentRepository;
import ctoy2work.example.tistorycomment.repository.JpaCommentRepository;
import ctoy2work.example.tistorycomment.repository.MemoryCommentRepository;
import ctoy2work.example.tistorycomment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public CommentRepository commentRepository() {
        // return new MemoryCommentRepository();
        return new JpaCommentRepository(em);
    }

    @Bean
    public CommentService commentService() {
        return new CommentService(commentRepository());
    }


}
