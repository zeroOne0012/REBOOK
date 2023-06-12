package dbteam4.booksale.repository;


import dbteam4.booksale.dto.InterestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterestMapper {

    void save(InterestDTO interestDTO);

    InterestDTO find(@Param("postId") Long postId, @Param("userId") Long userId);

    void delete(@Param("postId") Long postId, @Param("userId") Long userId);
}
