package dbteam4.booksale.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class School {
    private Long schoolId;
    private String university;
    private String department;
}
