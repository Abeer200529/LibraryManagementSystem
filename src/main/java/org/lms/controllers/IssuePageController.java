package org.lms.controllers;

import org.lms.services.BookServices;
import org.lms.services.StudentServices;
import org.lms.services.IssueRecordServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/issue-form")
public class IssuePageController {

    @Autowired
    private BookServices bookServices;

    @Autowired
    private StudentServices studentServices;

    @Autowired
    private IssueRecordServices issueServices;

    @GetMapping("/new")
    public String showIssueForm(Model model) {
        model.addAttribute("books", bookServices.getAllBooks());
        model.addAttribute("students", studentServices.getAllStudent());
        return "issue-book";
    }

    @PostMapping("/save")
    public String issueBook(@RequestParam Integer bookId,
                            @RequestParam Integer studentId) {

        issueServices.issueBook(bookId, studentId);

        return "redirect:/issues-page";
    }
    @PostMapping("/return/{id}")
    public String returnBook(@PathVariable Integer id) {

        issueServices.returnBook(id);

        return "redirect:/issues-page";
    }
}