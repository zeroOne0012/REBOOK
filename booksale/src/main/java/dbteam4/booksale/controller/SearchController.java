package dbteam4.booksale.controller;

import dbteam4.booksale.constant.BookSearchType;
import dbteam4.booksale.domain.Book;
import dbteam4.booksale.domain.Post;
import dbteam4.booksale.dto.BookPostsDTO;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.dto.PostSearchCond;
import dbteam4.booksale.service.BookService;
import dbteam4.booksale.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final BookService bookService;
    @GetMapping()
    public String search(@RequestParam("keyword") String keyword, @RequestParam("condition") String condition, Model model)
    {
        keyword = keyword.replaceAll(" ", "");
        BookSearchCond bookSearchCond = new BookSearchCond(keyword, BookSearchType.valueOf(condition));

        List<BookPostsDTO> booksWithsPosts = bookService.findAll(bookSearchCond);
        model.addAttribute("booksWithsPosts", booksWithsPosts);

        return "search";
    }

    @GetMapping("{bookISBN}")
    public String selected(@PathVariable String bookISBN, Model model,
                           @RequestParam(required = false) Long underPrice, @RequestParam(required = false) Long discountRate,
                           @RequestParam(required = false) Boolean onSale, @RequestParam(required = false) Boolean reserved,
                           @RequestParam(required = false) Boolean sold, @RequestParam(required = false) String shippingMethod,
                           HttpServletRequest request) {

        String referer = request.getHeader("referer");
        PostSearchCond postSearchCond = new PostSearchCond(underPrice, discountRate, onSale, reserved, sold, shippingMethod);

        System.out.println("postSearchCond = " + postSearchCond);





        BookPostsDTO bookPostsDTO = bookService.findBookWithPostsByISBN(bookISBN, postSearchCond);

        Book book = bookService.findByISBN(bookISBN);

        model.addAttribute("book", book);
        model.addAttribute("bookPostsDTO", bookPostsDTO);

        return "selected";
    }
}