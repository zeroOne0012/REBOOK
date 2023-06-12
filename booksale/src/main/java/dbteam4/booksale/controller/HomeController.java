package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.PostBookDTO;
import dbteam4.booksale.repository.UserMapper;
import dbteam4.booksale.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;
//    @GetMapping("/")
//    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false)User loginUser, Model model) {
//
//        //세션에 회원 데이터가 없으면 home
//        if(loginUser == null) {
//            return "index";
//        }
//
//        //세션이 확인되면 로그인으로 이동
//        model.addAttribute("user", loginUser);
//        return "loginIndex";
//    }

    @GetMapping("/")
    public String home(Model model) {
        List<PostBookDTO> recentPosts = postService.findRecentPost(3);

        model.addAttribute("recentPosts", recentPosts);



        return "index";
    }
}
