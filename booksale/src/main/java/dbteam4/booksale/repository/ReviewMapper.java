package dbteam4.booksale.repository;

import dbteam4.booksale.dto.PostReviewDTO;
import dbteam4.booksale.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    void save(ReviewDTO reviewDTO);

    ReviewDTO findByPostId(Long postId);

    List<PostReviewDTO> findByWriterId(Long writerId);

    List<ReviewDTO> findBySellerId(Long sellerId);
}
