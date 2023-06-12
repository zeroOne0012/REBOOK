package dbteam4.booksale.service;

import dbteam4.booksale.constant.BookSearchType;
import dbteam4.booksale.domain.Post;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.dto.PostBookDTO;
import dbteam4.booksale.repository.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostMapper postMapper;
    @Test
    void findPostList() {
        BookSearchCond bookSearchCond = new BookSearchCond();

        bookSearchCond.setKeyword("마리오");
        bookSearchCond.setBookSearchType(BookSearchType.author);

        List<PostBookDTO> postList = postMapper.findAll(bookSearchCond);

        System.out.println("postList = " + postList);
    }
}