package com.solvd.book.service;

import com.solvd.book.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> retrieveAll();

    Book create(Book book);

}
