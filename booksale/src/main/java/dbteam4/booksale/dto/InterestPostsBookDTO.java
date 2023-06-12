package dbteam4.booksale.dto;


import dbteam4.booksale.domain.Book;
import dbteam4.booksale.domain.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class InterestPostsBookDTO {
    private List<PostBookDTO> postBookDTOList;
}
