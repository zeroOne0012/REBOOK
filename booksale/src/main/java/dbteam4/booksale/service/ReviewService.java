package dbteam4.booksale.service;

import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.PostReviewDTO;
import dbteam4.booksale.dto.RegisterDTO;
import dbteam4.booksale.dto.ReviewDTO;
import dbteam4.booksale.repository.ReviewMapper;
import dbteam4.booksale.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;
    private final UserMapper userMapper;

    public void saveReview(ReviewDTO reviewDTO) {
        ReviewDTO findReview = findByPostId(reviewDTO.getPostId());
        if (findReview == null) { // review - post 는 1:1 관계.
            reviewMapper.save(reviewDTO);


            User sellUser = userMapper.findById(reviewDTO.getSellerId());
            int rating = reviewDTO.getRating();
            rating -= 3;

            userMapper.plusMileage(sellUser.getId(), rating);
        }
    }

    public ReviewDTO findByPostId(Long postId) {
        return reviewMapper.findByPostId(postId);
    }

    public List<ReviewDTO> findBySellerId(Long sellerId) {
        return reviewMapper.findBySellerId(sellerId);
    }

    public List<PostReviewDTO> findByWriterId(Long writerId) {return reviewMapper.findByWriterId(writerId);}
}
