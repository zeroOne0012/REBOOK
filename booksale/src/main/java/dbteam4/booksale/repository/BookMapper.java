package dbteam4.booksale.repository;

import dbteam4.booksale.domain.Book;
import dbteam4.booksale.dto.BookDTO;
import dbteam4.booksale.dto.BookPostsDTO;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.dto.PostSearchCond;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    void save(BookDTO bookDTO);

    Book findByISBN(String ISBN);

    BookPostsDTO findBookWithPostsByISBN(@Param("ISBN") String ISBN, @Param("cond") PostSearchCond postSearchCond);
    List<BookPostsDTO> findAll(BookSearchCond bookSearchCond);

}
