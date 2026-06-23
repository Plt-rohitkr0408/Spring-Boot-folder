package com.exmaple.Library_Mngt_demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="issueBook")
public class IssueBook {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer issueId;

    @Column(name="issue_date" )
    private LocalDateTime issueDate;

    @Column(name="due_date" )
    private LocalDateTime dueDate;

    @Column(name="return_date" )
    private LocalDateTime returnDate;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "std_id")
    private Student student;

    @Column(name="fine")
    private Double fineAmount;

    public IssueBook() {}

    public IssueBook(Double fineAmount, Student student, Book book,
                     LocalDateTime returnDate, LocalDateTime dueDate,
                     LocalDateTime issueDate, Integer issueId) {
        this.fineAmount = fineAmount;
        this.student = student;
        this.book = book;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
        this.issueDate = issueDate;
        this.issueId = issueId;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
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

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }
}
