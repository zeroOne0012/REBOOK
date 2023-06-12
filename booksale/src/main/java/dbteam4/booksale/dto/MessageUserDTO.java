package dbteam4.booksale.dto;


import dbteam4.booksale.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MessageUserDTO {
    private Long messageId;
    private User senderUser;
    private User receiverUser;
    private LocalDateTime sendTime;
    private String messageContent;
    private String userFair;
}
