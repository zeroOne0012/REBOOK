package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.ReviewDTO;
import dbteam4.booksale.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    @PostMapping ("/save")
    public String saveReview(HttpServletRequest request, @ModelAttribute ReviewDTO reviewDTO,
                             @SessionAttribute(name = SessionConst.LOGIN_USER) User loginUser) {
        String referer = request.getHeader("Referer");

        reviewDTO.setWriterId(loginUser.getId());
        reviewDTO.setReviewTime(LocalDateTime.now());



        System.out.println("reviewDTO = " + reviewDTO);

        reviewService.saveReview(reviewDTO);

        return "redirect:" + referer;
    }
}
