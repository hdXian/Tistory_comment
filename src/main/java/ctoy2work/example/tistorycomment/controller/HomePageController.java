package ctoy2work.example.tistorycomment.controller;

import ctoy2work.example.tistorycomment.domain.Comment;
import ctoy2work.example.tistorycomment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/comments/modify/{id}")
    public String commentModifyForm(@PathVariable("id") Long id, Model model) {
        Comment comment = commentService.getComment(id).get();
        model.addAttribute("comment", comment);
        return "/comments/modifyForm";
    }

    @PostMapping("/comments/update/{id}")
    public String modifyComment(@PathVariable("id") Long id, CommentForm form,
                                Model model) {
        String password = commentService.getComment(id).get().getPassword();
        if (password.equals(form.getPasswd())) {
            String modifiedComment = form.getText();
            commentService.ModifyComment(id, modifiedComment);
            return "redirect:/";
        }
        else {
            return "redirect:/comments/modifyForm";
        }
    }

    @GetMapping("/comments/delete/{id}")
    public String deleteCommentForm(@PathVariable("id") Long id, Model model) {
        Comment comment = commentService.getComment(id).get();
        model.addAttribute("comment", comment);
        return "/comments/deleteForm";
    }

    @PostMapping("/comments/delete/{id}")
    public String deleteComment(@PathVariable Long id, CommentForm form) {
        // form.getpasswd()를 통해 암호를 확인하는 로직

        commentService.DeleteComment(id);
        return "redirect:/";
    }

}
