package com.exmaple.Library_Mngt_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name="book_title" , nullable = false, length = 30)
    private String bookName;

    @Column(length=30)
    private String author;

    @Column(name="book_edition" , length = 30 , nullable = false)
    private String edition;

    @Column(name ="book_qty")
    private Integer qty;

    @Column(name ="book_category" , length = 30)
    private String category;

    public Book(){

    }

    public Book(Integer bookId, String bookName, String author, String edition, Integer qty, String category) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.edition = edition;
        this.qty = qty;
        this.category = category;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
