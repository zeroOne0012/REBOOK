package dbteam4.booksale.repository;

import dbteam4.booksale.domain.Post;
import dbteam4.booksale.dto.PostBookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostMapperTest {

    @Autowired
    private PostMapper postMapper;
    @Test
    void findByPostId() {
        PostBookDTO postBookDTO = postMapper.findByPostId(13L);

        System.out.println("postBookDTO = " + postBookDTO);

    }

    @Test
    void findRecentPost() {
        List<PostBookDTO> recentPosts = postMapper.findRecentPost(3);

        for (PostBookDTO post : recentPosts) {
            System.out.println("post = " + post);
        }


    }

    @Test
    void findInterestPost() {
        List<PostBookDTO> postBookDTOList = postMapper.findInterestPost(25L);

        for (PostBookDTO postBookDTO : postBookDTOList) {
            System.out.println("postBookDTO = " + postBookDTO);
        }
    }
}