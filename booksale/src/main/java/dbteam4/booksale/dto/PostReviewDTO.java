package dbteam4.booksale.dto;

import dbteam4.booksale.domain.Book;
import dbteam4.booksale.domain.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class PostReviewDTO {
    private Long reviewId;
    private Long postId;
    private Long writerId;
    private Long sellerId;
    private String reviewContent;
    private LocalDateTime reviewTime;
    private int rating;
    private Book book;
    private Post post;
}
