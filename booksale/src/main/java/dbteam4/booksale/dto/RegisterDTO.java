package dbteam4.booksale.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class RegisterDTO {
    private Long id;
    private String userName;
    private String phoneNumber;
    private String userID;
    private String password;
    private String university;
    private String department; // 학과
    private int mileage;
}
