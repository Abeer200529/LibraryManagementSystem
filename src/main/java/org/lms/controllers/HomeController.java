package org.lms.controllers;

import org.lms.services.BookServices;
import org.lms.services.StudentServices;
import org.lms.services.IssueRecordServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private BookServices bookServices;

    @Autowired
    private StudentServices studentServices;

    @Autowired
    private IssueRecordServices issueServices;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/books-page")
    public String books(Model model) {
        model.addAttribute("books", bookServices.getAllBooks());
        return "books";
    }

    @GetMapping("/students-page")
    public String students(Model model) {
        model.addAttribute("students", studentServices.getAllStudent());
        return "students";
    }

    @GetMapping("/issues-page")
    public String issues(Model model) {
        model.addAttribute("issues", issueServices.getAllIssues());
        return "issues";
    }
}