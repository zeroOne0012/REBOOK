package dbteam4.booksale.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReviewDTO {
    private Long reviewId;
    private Long postId;
    private Long writerId;
    private Long sellerId;
    private int rating;
    private String reviewContent;
    private LocalDateTime reviewTime;
}
