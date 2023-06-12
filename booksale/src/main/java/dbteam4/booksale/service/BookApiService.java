package dbteam4.booksale.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dbteam4.booksale.domain.Book;
import dbteam4.booksale.dto.BookDTO;
import dbteam4.booksale.repository.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookApiService {

    private final BookMapper bookMapper;
    private final String bookURL = "https://openapi.naver.com/v1/search/book_adv.xml";
    private final String naverClientID = "xjq2M8oWWnuITSg4O_jw";
    private final String naverClientSecret = "xPWTZ3k2gu";

    public void saveBook(String ISBN) {
        Book bookInDB = bookMapper.findByISBN(ISBN);

        if (bookInDB == null) {
            BookDTO bookData = getBookData(ISBN);
            bookMapper.save(bookData);
        }
    }

    public String bookSearch(String searchWord) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity request = getHttpEntity();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl("https://openapi.naver.com/v1/search/book.json")
                .queryParam("query", searchWord);

        URI uri = uriComponentsBuilder.build().encode().toUri();

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
        return response.getBody();
    }

    private BookDTO getBookData(String ISBN) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity request = getHttpEntity();

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(bookURL)
                .queryParam("d_isbn", ISBN)
                .encode()
                .toUriString();

        ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, request, String.class);

        String parsedXML = parseForBookInfo(response.getBody());
        BookDTO bookDTO = xmlToObject(parsedXML);

        bookDTO.setAuthor(bookDTO.getAuthor().replaceAll("\\^", ","));

        return bookDTO;
    }

    private HttpEntity getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-Naver-Client-Id", naverClientID);
        headers.set("X-Naver-Client-Secret", naverClientSecret);

        HttpEntity request = new HttpEntity(headers);
        return request;
    }

    private String parseForBookInfo(String xml) {
        String startToken = "<item>";
        String endToken = "</item>";

        int startNum = xml.indexOf(startToken);
        int endNum = xml.indexOf(endToken);

        return xml.substring(startNum, endNum + endToken.length());
    }

    private BookDTO xmlToObject(String xml)  {
        XmlMapper xmlMapper = new XmlMapper();
        BookDTO bookDTO = null;
        try {
            bookDTO = xmlMapper.readValue(xml, BookDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return bookDTO;
    }
}
