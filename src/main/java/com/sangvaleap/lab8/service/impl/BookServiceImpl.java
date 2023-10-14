package com.sangvaleap.lab8.service.impl;

import com.sangvaleap.lab8.model.Book;
import com.sangvaleap.lab8.repository.BookRepository;
import com.sangvaleap.lab8.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) throws Exception{
        return bookRepository.findById(id).orElseThrow(()-> new Exception("Book is not found."));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public Book updateBook(Long id, Book book) throws Exception{
        if(bookRepository.existsById(id)) {
            return bookRepository.save(book);
        }else{
            throw new Exception("Book is not found.");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public void deleteBook(Long id) throws Exception{
        if(bookRepository.existsById(id)) {
              bookRepository.deleteById(id);
        }else{
            throw new Exception("Book is not found.");
        }

    }
}
