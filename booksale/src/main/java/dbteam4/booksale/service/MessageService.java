package dbteam4.booksale.service;


import dbteam4.booksale.dto.MessageDTO;
import dbteam4.booksale.dto.MessageUserDTO;
import dbteam4.booksale.repository.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageMapper messageMapper;

    public void save(MessageDTO messageDTO) {
        messageMapper.save(messageDTO);
    }

    public List<MessageDTO> findByTwoId(Long user1Id, Long user2Id) {
        return messageMapper.findByTwoId(user1Id, user2Id);
    }

    public List<MessageDTO> findById(Long userId) {
        return messageMapper.findById(userId);
    }

    public List<MessageUserDTO> findLastMessageList(Long userId) {
        return messageMapper.findLastMessageList(userId);
    }


}
