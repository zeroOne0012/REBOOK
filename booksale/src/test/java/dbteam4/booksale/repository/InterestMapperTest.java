package dbteam4.booksale.repository;

import dbteam4.booksale.dto.InterestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InterestMapperTest {

    @Autowired
    private InterestMapper interestMapper;
    @Test
    void findByPostIdAndUserId() {
        InterestDTO byPostIdAndUserId = interestMapper.find(37l, 15l);
        System.out.println("byPostIdAndUserId = " + byPostIdAndUserId);

    }
}