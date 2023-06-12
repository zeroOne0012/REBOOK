package dbteam4.booksale.service;

import dbteam4.booksale.domain.School;
import dbteam4.booksale.repository.SchoolMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SchoolServiceTest {

    @Autowired
    private SchoolService schoolService;
    @Test
    void findAllSchool() {
        List<School> allSchool = schoolService.findAllSchool();

        System.out.println("allSchool = " + allSchool);
    }

    @Test
    void findAllSchoolByMap() {
        HashMap<String, List<String>> allSchoolByMap = schoolService.findAllSchoolByMap();
        
        System.out.println("allSchoolByMap = " + allSchoolByMap);
    }
}