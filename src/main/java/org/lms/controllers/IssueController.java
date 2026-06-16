package org.lms.controllers;

import org.lms.entities.IssueRecord;
import org.lms.services.IssueRecordServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueRecordServices issueRecordService;

    @PostMapping
    public IssueRecord addIssue(@RequestBody IssueRecord issueRecord){
        return issueRecordService.saveIssue(issueRecord);
    }

    @GetMapping
    public List<IssueRecord> getAllIssues(){
        return issueRecordService.getAllIssues();
    }

    @GetMapping("/{id}")
    public IssueRecord getIssue(@PathVariable Integer id){
        return issueRecordService.getIssue(id)
                .orElseThrow(() -> new RuntimeException("Issue Record not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteIssue(@PathVariable Integer id){
        issueRecordService.deleteIssue(id);
        return "Issue Record deleted successfully";
    }
    // Issue a book
    @PostMapping("/issue")
    public IssueRecord issueBook(
            @RequestParam Integer bookId,
            @RequestParam Integer studentId) {

        return issueRecordService.issueBook(bookId, studentId);
    }

    // Return a book
    @PutMapping("/return/{issueId}")
    public IssueRecord returnBook(@PathVariable Integer issueId) {

        return issueRecordService.returnBook(issueId);
    }
}