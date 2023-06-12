package dbteam4.booksale.controller.api;

import dbteam4.booksale.service.BookApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("bookApi")
public class BookApiController {

    private final BookApiService bookApiService;

    @GetMapping("/search-json")
    public String search(@RequestParam("search") String keyword) {
        String result = bookApiService.bookSearch(keyword);
        return result;
    }


}
