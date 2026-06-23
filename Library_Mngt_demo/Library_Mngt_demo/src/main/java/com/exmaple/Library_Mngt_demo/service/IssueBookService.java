package com.exmaple.Library_Mngt_demo.service;

import com.exmaple.Library_Mngt_demo.entity.IssueBook;

import java.util.List;

public interface IssueBookService {
    IssueBook issueBook(Integer bookId, Integer stdId);
    IssueBook returnBook(Integer issueId);
    List<IssueBook> getAllIssueBooks();
    IssueBook getIssuebyId(Integer issueId);
}
