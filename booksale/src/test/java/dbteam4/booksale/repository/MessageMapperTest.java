package dbteam4.booksale.repository;

import dbteam4.booksale.dto.MessageDTO;
import dbteam4.booksale.dto.MessageUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageMapperTest {

    @Autowired
    private MessageMapper messageMapper;
    @Test
    void findByTwoId() {
        List<MessageDTO> messages = messageMapper.findByTwoId(15L, 25L);

        for (MessageDTO message : messages) {
            System.out.println("message = " + message);
        }
    }

    @Test
    void findById() {
        List<MessageDTO> messages = messageMapper.findById(15L);

        for (MessageDTO message : messages) {
            System.out.println("message = " + message);
        }
    }

    @Test
    void findLastMessageList() {
        List<MessageUserDTO> lastMessageList = messageMapper.findLastMessageList(25L);

        for (MessageUserDTO message : lastMessageList) {
            System.out.println("message = " + message);
        }
    }
}