package org.lms.services;

import org.lms.entities.Book;
import org.lms.entities.IssueRecord;
import org.lms.entities.Student;
import org.lms.repo.BookRepo;
import org.lms.repo.IssueRecordRepo;
import org.lms.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IssueRecordServices {

    @Autowired
    private IssueRecordRepo issueRecordRepo;

    public IssueRecord saveIssue(IssueRecord issueRecord){
        return issueRecordRepo.save(issueRecord);
    }

    public List<IssueRecord> getAllIssues(){
        return issueRecordRepo.findAll();
    }

    public Optional<IssueRecord> getIssue(Integer id){
        return issueRecordRepo.findById(id);
    }

    public void deleteIssue(Integer id){
        issueRecordRepo.deleteById(id);
    }
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private StudentRepo studentRepo;
    public IssueRecord issueBook(Integer bookId, Integer studentId) {

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Book not available");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepo.save(book);

        IssueRecord record = new IssueRecord();
        record.setBook(book);
        record.setStudent(student);
        record.setIssueDate(LocalDate.now());

        return issueRecordRepo.save(record);
    }
    public IssueRecord returnBook(Integer issueId) {

        IssueRecord record = issueRecordRepo.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue record not found"));

        record.setReturnDate(LocalDate.now());

        Book book = record.getBook();
        book.setQuantity(book.getQuantity() + 1);

        bookRepo.save(book);

        return issueRecordRepo.save(record);
    }
}