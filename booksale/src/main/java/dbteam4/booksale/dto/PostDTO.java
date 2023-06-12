package dbteam4.booksale.dto;

import dbteam4.booksale.domain.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PostDTO {
    private Long postId;
    private String ISBN;
    private Long sellerId;
    private String postTitle;
    private String postContent;
    private String salesMethod;
    private Long postPrice;
    private String shippingMethod;
    private String bookQuality;
    private LocalDateTime postTime;
}
