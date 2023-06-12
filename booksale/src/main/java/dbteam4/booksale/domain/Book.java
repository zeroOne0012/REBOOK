package dbteam4.booksale.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private String pubDate;
    private String image; // imageURL
    private int discount;
    private String description;
}
