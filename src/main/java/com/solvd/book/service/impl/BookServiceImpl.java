package com.solvd.book.service.impl;

import com.solvd.book.domain.Book;
import com.solvd.book.persistence.BookRepository;
import com.solvd.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final RestTemplate restTemplate;

    @Override
    public List<Book> retrieveAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(Book book) {
        Boolean isExists = restTemplate.getForObject("http://localhost:8081/api/v1/authors/{authorId}",
                Boolean.class,
                book.getAuthorId());
        if(Boolean.FALSE.equals(isExists)){
            throw new IllegalArgumentException("Author's id is incorrect!");
        }
        return bookRepository.save(book);
    }

}
