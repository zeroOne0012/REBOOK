package dbteam4.booksale.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class InterestDTO {
    private Long postId;
    private Long userId;
    private LocalDateTime setTime;
}
