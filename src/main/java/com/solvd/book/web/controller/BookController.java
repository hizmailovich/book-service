package com.solvd.book.web.controller;

import com.solvd.book.domain.Book;
import com.solvd.book.service.BookService;
import com.solvd.book.web.dto.BookDto;
import com.solvd.book.web.dto.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping()
    public List<BookDto> getAll() {
        List<Book> books = bookService.retrieveAll();
        return bookMapper.toDto(books);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@Validated @RequestBody BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        book = bookService.create(book);
        return bookMapper.toDto(book);
    }

}
