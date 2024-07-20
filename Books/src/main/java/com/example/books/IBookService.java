package com.example.books;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    public void createBookById(Book book);
    public void updateBook(long id, Book book);
    public void deleteBook(long id);
}
