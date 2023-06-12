package dbteam4.booksale.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class LoginDTO {
    private String loginID;
    private String password;
}
