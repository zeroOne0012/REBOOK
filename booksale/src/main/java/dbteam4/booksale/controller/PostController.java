package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.Post;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.*;
import dbteam4.booksale.service.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final ReviewService reviewService;
    private final BookApiService bookApiService;
    private final InterestService interestService;

    @GetMapping()
    public String post(@SessionAttribute(name = SessionConst.LOGIN_USER) User loginUser) {

        return "post";
    }

    @PostMapping()
    public String savePost(@ModelAttribute PostDTO postDTO, @SessionAttribute(name = SessionConst.LOGIN_USER) User loginUser) {
        postDTO.setSellerId(loginUser.getId());
        postDTO.setPostTime(LocalDateTime.now());

        System.out.println("postDTO = " + postDTO);

        //무조건 책 먼저 저장해야함
        bookApiService.saveBook(postDTO.getISBN());
        postService.savePost(postDTO);

        return "redirect:/";
    }

    @GetMapping("/view/{postId}")
    public String view(@PathVariable Long postId, Model model,
                       @SessionAttribute(name = SessionConst.LOGIN_USER, required = false) User loginUser) {
        PostBookDTO post = postService.findByPostId(postId);
        ReviewDTO review = reviewService.findByPostId(postId);
        List<ReviewDTO> sellerReviewList = reviewService.findBySellerId(post.getSellerId());




        Long sellerId = post.getSellerId();
        String userName = userService.findById(sellerId).getUserName();

        model.addAttribute("post", post);
        model.addAttribute("userName", userName);
        model.addAttribute("review", review);
        model.addAttribute("sellerReviewList", sellerReviewList);

        if (loginUser != null) {
            InterestDTO interestDTO = interestService.findByPostIdAndUserId(postId, loginUser.getId());
            if (interestDTO != null) {
                model.addAttribute("isAlreadyInterest", true);
            }
        }


        return "postview";
    }

    @GetMapping("/otherview")
    public String otherview(){return "postviewothers";}

    @PostMapping("/view/status")
    public String status(@RequestParam("postId") Long postId,
                         @RequestParam("postStatus") String postStatus,
                         HttpServletRequest request){
        String referer = request.getHeader("referer");

        postService.updateST(postId, postStatus);

        return "redirect:" + referer;
    }
}
