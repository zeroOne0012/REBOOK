package dbteam4.booksale.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MessageDTO {
    private Long messageId;
    private Long senderId;
    private Long receiverId;
    private LocalDateTime sendTime;
    private String messageContent;
    private String userFair;
}
