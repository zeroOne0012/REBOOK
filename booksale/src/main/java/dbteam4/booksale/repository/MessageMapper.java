package dbteam4.booksale.repository;

import dbteam4.booksale.dto.MessageDTO;
import dbteam4.booksale.dto.MessageUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    void save(MessageDTO messageDTO);

    List<MessageDTO> findByTwoId(Long user1Id, Long user2Id);

    List<MessageDTO> findById(Long userId);

    List<MessageUserDTO> findLastMessageList(Long userId);

}
