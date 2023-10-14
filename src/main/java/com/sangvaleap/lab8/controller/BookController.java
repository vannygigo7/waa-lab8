package com.sangvaleap.lab8.controller;

import com.sangvaleap.lab8.model.Book;
import com.sangvaleap.lab8.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/books"})
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(value = {"/{id}"})
    public Book getBookById(@PathVariable long id) throws Exception {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return  bookService.addBook(book);
    }

    @PutMapping(value = {"/{id}"})
    public Book updateBook(@PathVariable long id, @RequestBody Book book) throws Exception {
       return bookService.updateBook(id, book);
    }

    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable long id)  throws Exception{
        bookService.deleteBook(id);
    }
}
