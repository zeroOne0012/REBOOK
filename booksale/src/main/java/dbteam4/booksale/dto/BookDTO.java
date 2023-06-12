package dbteam4.booksale.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter @Setter
@ToString
public class BookDTO {
    private String ISBN;
    private String title;
    private String link; // don't save in db
    private String image; // imageURL
    private String author;
    private int discount;
    private String publisher;
    private String pubdate;
    private String description;
}
