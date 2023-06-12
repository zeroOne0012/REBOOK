package dbteam4.booksale.service;


import dbteam4.booksale.dto.InterestDTO;
import dbteam4.booksale.repository.InterestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterestService {
    private final InterestMapper interestMapper;

    public void saveInterest(InterestDTO interestDTO) {
        interestMapper.save(interestDTO);
    }

    public InterestDTO findByPostIdAndUserId(Long postId, Long userId) {
        return interestMapper.find(postId, userId);
    }

    public void deleteInterest(Long postId, Long userId) {
        interestMapper.delete(postId, userId);
    }
}
