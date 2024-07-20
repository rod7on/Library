package com.example.books;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/books/v1")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.createBookById(book);
    }

    @PutMapping(path = "/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable long id) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

}
