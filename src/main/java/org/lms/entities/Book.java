package org.lms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_seq",
            sequenceName = "book_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_seq"
    )
    private Integer id;
    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    @Column(name = "IS_BN")
    private String isbn;

    @Min(0)
    private int quantity;
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book() {
    }

    public Book(Integer id,String author,String title ,String isbn,int quantity) {
        this.quantity = quantity;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", isBn='" + isbn + '\'' +
                '}';
    }
}
