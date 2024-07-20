package com.example.books;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createBookById(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(long id, Book book) {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Employe with id %s dosn't exist", id)));
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setPublisher(book.getPublisher());
        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setTitle(book.getTitle());

        bookRepository.save(bookToUpdate);
    }

    @Override
    public void deleteBook(long id) {
        Book bookToDelete = bookRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Employe with id %s dosn't exist", id)));
        bookRepository.deleteById(id);
    }
}


