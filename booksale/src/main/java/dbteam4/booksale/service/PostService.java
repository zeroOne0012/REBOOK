package dbteam4.booksale.service;

import dbteam4.booksale.dto.PostBookDTO;
import dbteam4.booksale.dto.PostDTO;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.dto.ReviewDTO;
import dbteam4.booksale.repository.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostMapper postMapper;

    public void savePost(PostDTO postDTO) {
        postMapper.save(postDTO);
    }
    public void updateST(Long postId, String postStatus) {

        postMapper.updateST(postId, postStatus);
    }

    public PostBookDTO findByPostId(Long postId) {
        return postMapper.findByPostId(postId);
    }

    public List<PostBookDTO> findRecentPost(int recentNum) {
        return postMapper.findRecentPost(recentNum);
    }

    public List<PostBookDTO> findInterestPost(Long userId) {
        return postMapper.findInterestPost(userId);
    }

    public List<PostBookDTO> findPostList(BookSearchCond bookSearchCond) {
        List<PostBookDTO> postList = postMapper.findAll(bookSearchCond);
        return postList;
    }

    public List<PostBookDTO> findUserPost(Long id) {
        List<PostBookDTO> postList = postMapper.findUserPost(id);
        return postList;
    }
}
