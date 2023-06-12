package dbteam4.booksale.dto;

import dbteam4.booksale.domain.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BookPostsDTO {
    private String ISBN;
    private String title;
    private String image; // imageURL
    private String author;
    private int discount;
    private String publisher;
    private String pubDate;
    private String description;
    private List<Post> postList;
}

