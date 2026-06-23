package com.exmaple.Library_Mngt_demo.service.impl;

import com.exmaple.Library_Mngt_demo.entity.Book;
import com.exmaple.Library_Mngt_demo.exception.ResourceException;
import com.exmaple.Library_Mngt_demo.repository.BookRepository;
import com.exmaple.Library_Mngt_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).
                orElseThrow(()-> new ResourceException("Book not found Id -> " +id ));
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        Book existingBook = bookRepository.findById(id).
                orElseThrow(()-> new ResourceException("Book not found Id -> " +id ));
        existingBook.setBookName(book.getBookName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setCategory(book.getCategory());
        existingBook.setQty(book.getQty());
        existingBook.setCategory(book.getCategory());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
