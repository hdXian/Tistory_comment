package ctoy2work.example.tistorycomment;

import ctoy2work.example.tistorycomment.repository.CommentRepository;
import ctoy2work.example.tistorycomment.repository.MemoryCommentRepository;
import ctoy2work.example.tistorycomment.service.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public CommentRepository commentRepository() {
        return new MemoryCommentRepository();
    }

    @Bean
    public CommentService commentService() {
        return new CommentService(commentRepository());
    }


}
