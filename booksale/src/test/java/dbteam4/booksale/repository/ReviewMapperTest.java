package dbteam4.booksale.repository;

import dbteam4.booksale.dto.ReviewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewMapperTest {

    @Autowired
    private ReviewMapper reviewMapper;
    @Test
    void findByPostId() {
        ReviewDTO reviewDTO = reviewMapper.findByPostId(18l);
        System.out.println("reviewDTO = " + reviewDTO);
    }

    @Test
    void findBySellerId() {
        List<ReviewDTO> reviewDTOs = reviewMapper.findBySellerId(17l);

        for (ReviewDTO reviewDTO : reviewDTOs) {
            System.out.println("reviewDTO = " + reviewDTO);
        }
    }
}