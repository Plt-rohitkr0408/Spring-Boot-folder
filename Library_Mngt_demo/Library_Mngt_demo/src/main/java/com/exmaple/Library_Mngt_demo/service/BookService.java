package com.exmaple.Library_Mngt_demo.service;

import com.exmaple.Library_Mngt_demo.entity.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> findAll();
    Book findById(Integer id);
    Book updateBook(Integer id,Book book);
    void deleteById(Integer id);
}
