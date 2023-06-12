package dbteam4.booksale.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dbteam4.booksale.dto.BookDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookApiServiceTest {

    @Autowired
    private BookApiService bookApiService;

    @Test
    void bookSearch() {

        String httpBody = bookApiService.bookSearch("영어");
        System.out.println("httpBody = " + httpBody);

    }
}