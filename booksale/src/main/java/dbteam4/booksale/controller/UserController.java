package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.*;
import dbteam4.booksale.repository.UserMapper;
import dbteam4.booksale.service.PostService;
import dbteam4.booksale.service.SchoolService;
import dbteam4.booksale.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import dbteam4.booksale.service.PostService;
import dbteam4.booksale.service.ReviewService;

import java.util.HashMap;
import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final SchoolService schoolService;
    private final UserService userService;
    private final PostService postService;
    private final ReviewService reviewService;
    private final UserMapper userMapper;



    @GetMapping("/register")
    public String register(Model model) {
        HashMap<String, List<String>> allSchoolByMap = schoolService.findAllSchoolByMap();
        model.addAttribute("schoolMajorMap", allSchoolByMap);
        return "user/register";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        String referrer = request.getHeader("Referer");
        session.setAttribute("previousPage", referrer);
        return "user/login";
    }

    @GetMapping("/info")
    public String userInfo(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false)User loginUser, Model model) {


        List<PostBookDTO> interestPostList = postService.findInterestPost(loginUser.getId());
        List<PostBookDTO> userPosts = postService.findUserPost(loginUser.getId());
        List<PostReviewDTO> userReviews = reviewService.findByWriterId(loginUser.getId());

        model.addAttribute("user", loginUser);
        model.addAttribute("interestPostList", interestPostList);
        model.addAttribute("UserReviews", userReviews);
        model.addAttribute("UserPosts", userPosts);
        return "user/userInfo";
    }

    @GetMapping("/edit")
    public String userEdit(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false)User loginUser, Model model) {
        HashMap<String, List<String>> allSchoolByMap = schoolService.findAllSchoolByMap();
        model.addAttribute("schoolMajorMap", allSchoolByMap);

        model.addAttribute("user", loginUser);
        return "user/userEdit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute RegisterDTO registerDTO) {
        userService.save(registerDTO);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpServletRequest request) {
        User loginUser = userService.login(loginDTO.getLoginID(), loginDTO.getPassword());


        if (loginUser == null) {
            return "user/login";
        }

        else {
            //로그인 성공 처리
            //세션이 있으면 세션 반환, 없으면 신규 세션 생성
            HttpSession session = request.getSession();
            //세션에 로그인 회원 정보 보관
            session.setAttribute(SessionConst.LOGIN_USER, loginUser);

            String previousPage = (String) session.getAttribute("previousPage");
            session.removeAttribute("previousPage");

            if (previousPage != null) {return "redirect:" + previousPage;}
            else {return "redirect:/";}

        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        String referer = request.getHeader("Referer");

        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:" + referer;
    }

    @PostMapping("/edit")
    public String userEdit(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false)User loginUser,
                           @ModelAttribute RegisterDTO registerDTO){

        User user = loginUser;

        userService.update(user, registerDTO);

        //임시
        loginUser.setUserName(registerDTO.getUserName());
        loginUser.setPhoneNumber(registerDTO.getPhoneNumber());
        loginUser.setUserID(registerDTO.getUserID());

        return "redirect:/user/info";
    }

}
