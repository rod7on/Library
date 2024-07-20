package com.example.books;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @SequenceGenerator(
            name = "sequence_generator",
            allocationSize = 1
    )

    @GeneratedValue(
            generator = "sequence_generator",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private String author;
    @Setter
    @Getter
    private String publisher;
    @Setter
    @Getter
    private String isbn;

    public Book() {
    }

    public Book(String title, String author, String publisher, String isbn) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

}
