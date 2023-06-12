package dbteam4.booksale.service;


import dbteam4.booksale.domain.Book;
import dbteam4.booksale.dto.BookPostsDTO;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.dto.PostSearchCond;
import dbteam4.booksale.repository.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;

    public List<BookPostsDTO> findAll(BookSearchCond bookSearchCond) {
        return bookMapper.findAll(bookSearchCond);
    }

    public BookPostsDTO findBookWithPostsByISBN(String ISBN, PostSearchCond postSearchCond) {
        return bookMapper.findBookWithPostsByISBN(ISBN, postSearchCond);
    }

    public Book findByISBN(String ISBN) {
        return bookMapper.findByISBN(ISBN);
    }
}
