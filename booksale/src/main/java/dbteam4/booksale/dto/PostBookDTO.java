package dbteam4.booksale.dto;

import dbteam4.booksale.domain.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PostBookDTO {
    private Long postId;
    private Book book;
    private Long sellerId;
    private String postTitle;
    private String postContent;
    private String salesMethod;
    private int postPrice;
    private String shippingMethod;
    private String postStatus;
    private String bookQuality;
    private LocalDateTime postTime;
}
