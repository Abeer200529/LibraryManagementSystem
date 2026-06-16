package org.lms.controllers;

import org.lms.entities.Book;
import org.lms.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookServices bookService;

    @GetMapping("/books/new")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/books/save")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books-page"; // Redirects cleanly back to HomeController's route
    }

    @GetMapping("/books/edit/{id}")
    public String showEditBookForm(@PathVariable Integer id, Model model) {
        Book existingBook = bookService.getBook(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        model.addAttribute("book", existingBook);
        return "edit-book";
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@ModelAttribute("book") Book book, @PathVariable Integer id) {
        bookService.updateBook(book, id);
        return "redirect:/books-page";
    }
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "redirect:/books-page";
    }
}