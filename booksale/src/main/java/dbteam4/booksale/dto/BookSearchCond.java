package dbteam4.booksale.dto;


import dbteam4.booksale.constant.BookSearchType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
// 게시글 검색 조건에 관한 DTO
public class BookSearchCond {
    private String keyword;
    private BookSearchType bookSearchType;


    public BookSearchCond() {}

    public BookSearchCond(String keyword, BookSearchType bookSearchType) {
        this.keyword = keyword;
        this.bookSearchType = bookSearchType;
    }
}
