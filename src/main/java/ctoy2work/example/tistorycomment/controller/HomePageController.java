package ctoy2work.example.tistorycomment.controller;

import ctoy2work.example.tistorycomment.domain.Comment;
import ctoy2work.example.tistorycomment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private final CommentService commentService;

    public HomePageController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/") // 루트 디렉터리와 매핑.
    public String home(Model model) {
        List<Comment> comments = commentService.getCommentList();
        model.addAttribute("comments", comments);

        return "homePage";
    }

    @PostMapping("/")
    public String writeComment(CommentForm form) {
        Comment comment = new Comment();
        comment.setNickname(form.getName());
        comment.setPassword(form.getPasswd());
        comment.setCommentText(form.getText());

        commentService.AddComment(comment);

        return "redirect:/";
    }

    @GetMapping("/comments/modify")
    public String modifyForm() {
        return "/comments/modifyCommentForm";
    }

    @PostMapping("/comments/modify")
    public String modifyComment(CommentForm form) {
        return "";
    }

}
