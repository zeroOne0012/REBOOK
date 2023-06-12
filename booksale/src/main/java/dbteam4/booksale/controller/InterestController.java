package dbteam4.booksale.controller;


import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.InterestDTO;
import dbteam4.booksale.service.InterestService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/interest")
@RequiredArgsConstructor
public class InterestController {

    private final InterestService interestService;

    @PostMapping("/save")
    public String save(HttpServletRequest request, @RequestParam Long postId, @SessionAttribute(name = SessionConst.LOGIN_USER) User loginUser) {
        String referer = request.getHeader("referer");

        InterestDTO interestDTO = new InterestDTO();
        interestDTO.setPostId(postId);
        interestDTO.setUserId(loginUser.getId());
        interestDTO.setSetTime(LocalDateTime.now());

        interestService.saveInterest(interestDTO);

        return "redirect:" + referer;
    }

    @PostMapping("/delete")
    public String delete(HttpServletRequest request, @RequestParam Long postId, @SessionAttribute(name = SessionConst.LOGIN_USER) User loginUser) {
        String referer = request.getHeader("referer");
        Long userId = loginUser.getId();

        interestService.deleteInterest(postId, userId);

        return "redirect:" + referer;
    }

}
