package dbteam4.booksale.repository;

import dbteam4.booksale.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void plusMileage() {
        User user15 = userMapper.findById(15L);
        System.out.println("user15 = " + user15);

        userMapper.plusMileage(15L, 100);
        System.out.println("user15 = " + user15);
    }
}