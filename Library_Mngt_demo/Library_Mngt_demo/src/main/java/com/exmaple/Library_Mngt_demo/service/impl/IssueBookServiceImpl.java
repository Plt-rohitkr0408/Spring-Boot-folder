package com.exmaple.Library_Mngt_demo.service.impl;

import com.exmaple.Library_Mngt_demo.entity.Book;
import com.exmaple.Library_Mngt_demo.entity.IssueBook;
import com.exmaple.Library_Mngt_demo.entity.Student;
import com.exmaple.Library_Mngt_demo.exception.ResourceException;
import com.exmaple.Library_Mngt_demo.repository.BookRepository;
import com.exmaple.Library_Mngt_demo.repository.IssueBookRepository;
import com.exmaple.Library_Mngt_demo.repository.StudentRepository;
import com.exmaple.Library_Mngt_demo.service.FineService;
import com.exmaple.Library_Mngt_demo.service.IssueBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueBookServiceImpl implements IssueBookService {
    @Autowired
    private IssueBookRepository issueBookRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public IssueBook issueBook(Integer bookId, Integer stdId) {

        Book book = bookRepository.findById(bookId).
                orElseThrow(()->new ResourceException("Book not found"));
        Student student = studentRepository.findById(stdId).
                orElseThrow(()->new ResourceException("Student not found"));

        if(book.getQty() <=0){
            throw new ResourceException("Book Qty less than 0");
        }
        book.setQty(book.getQty() - 1);
        bookRepository.save(book);

        IssueBook issueBook = new IssueBook();
        issueBook.setBook(book);
        issueBook.setStudent(student);
        issueBook.setIssueDate(LocalDateTime.now());
        issueBook.setDueDate(LocalDateTime.now().plusDays(15));
        return issueBookRepository.save(issueBook);
    }

    @Override
    public IssueBook returnBook(Integer issueId) {
        IssueBook issueBook = issueBookRepository.findById(issueId).orElseThrow(()->new ResourceException("Book not found"));
        issueBook.setReturnDate(LocalDateTime.now());
        FineService fineService = new FineServiceImpl();
        Double fine = fineService.calculateFine(issueBook);
        issueBook.setFineAmount(fine);
        Book currentbook = issueBook.getBook();
        currentbook.setQty(currentbook.getQty() + 1);
        bookRepository.save(currentbook);
        return issueBookRepository.save(issueBook);
    }

    @Override
    public List<IssueBook> getAllIssueBooks() {
        return issueBookRepository.findAll();
    }

    @Override
    public IssueBook getIssuebyId(Integer issueId) {
        return issueBookRepository.findById(issueId).orElseThrow(()->new ResourceException("Book not found"));
    }
}
