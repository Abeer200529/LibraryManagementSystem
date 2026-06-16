package org.lms.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class IssueRecord {

    @Id
    @SequenceGenerator(
            name = "issue_record_seq",
            sequenceName = "issue_record_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "issue_record_seq"
    )
    private Integer id;

    private LocalDate issueDate;
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public IssueRecord() {
    }

    public IssueRecord(Integer id, LocalDate issueDate, LocalDate returnDate,
                       Book book, Student student) {
        this.id = id;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.book = book;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}