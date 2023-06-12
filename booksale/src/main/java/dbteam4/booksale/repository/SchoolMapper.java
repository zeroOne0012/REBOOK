package dbteam4.booksale.repository;

import dbteam4.booksale.domain.School;
import dbteam4.booksale.dto.SchoolDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolMapper {
    void save(SchoolDTO schoolDTO);
    List<School> findAll();
}
