package dbteam4.booksale.repository;

import dbteam4.booksale.constant.BookSearchType;
import dbteam4.booksale.domain.Book;
import dbteam4.booksale.domain.Post;
import dbteam4.booksale.dto.BookPostsDTO;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.dto.PostSearchCond;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    @DisplayName("IBSN에 맞는 책을 찾아오는지 확인하기")
    void findByISBN() {
        Book book = bookMapper.findByISBN("9791162242025");
    }
    @Test
    @DisplayName("book에 연관된 post들 잘 가져오는지 확인하기")
    void findAll() {
        BookSearchCond bookSearchCond = new BookSearchCond("데이터베이스", BookSearchType.all);

        List<BookPostsDTO> bookWithPosts = bookMapper.findAll(bookSearchCond);

        for (BookPostsDTO book : bookWithPosts) {
            String bookTitle = book.getTitle();
            System.out.println("bookTitle = " + bookTitle);

            List<Post> postList = book.getPostList();
            printPost(postList);

            System.out.println();
        }

    }
    @Test
    void findBookWithPostsByISBN() {
        PostSearchCond postSearchCond = new PostSearchCond();
        postSearchCond.setUnderPrice(20000L);
        postSearchCond.setReserved(true);
        postSearchCond.setShippingMethod("직거래");

        BookPostsDTO bookPostsDTO = bookMapper.findBookWithPostsByISBN("9791162242025", postSearchCond);
        System.out.println("postSearchCond = " + postSearchCond);

        List<Post> postList = bookPostsDTO.getPostList();

        for (Post post : postList) {
            System.out.println("post = " + post);
        }

        //printPost(postList);
    }

    private void printPost(List<Post>  postList) {
        for (Post post : postList) {
            String postTitle = post.getPostTitle();
            System.out.print(postTitle + ", ");
        }
    }
}