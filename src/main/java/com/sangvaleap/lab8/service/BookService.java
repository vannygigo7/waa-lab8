package com.sangvaleap.lab8.service;

import com.sangvaleap.lab8.model.Book;

import java.util.List;

public interface BookService {
     List<Book> getBooks();
     Book getBookById(Long id) throws Exception;
     Book addBook(Book book);

    Book updateBook(Long id, Book book) throws Exception;
     void deleteBook(Long id) throws Exception;
}
