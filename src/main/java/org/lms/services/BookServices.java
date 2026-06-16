package org.lms.services;

import org.lms.entities.Book;
import org.lms.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    @Autowired
    private BookRepo bookRepo;

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Optional<Book> getBook(Integer id){
        return bookRepo.findById(id);
    }

    public void deleteBook(Integer id){
        bookRepo.deleteById(id);
    }
    public Book updateBook(Book book, Integer id){

        Book existingBook = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setQuantity(book.getQuantity());

        return bookRepo.save(existingBook);
    }

}