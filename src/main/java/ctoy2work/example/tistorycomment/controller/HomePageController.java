package ctoy2work.example.tistorycomment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/") // 루트 디렉터리와 매핑.
    public String home() {
        return "home";
    }

}
