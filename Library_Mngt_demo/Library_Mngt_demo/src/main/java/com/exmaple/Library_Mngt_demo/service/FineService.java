package com.exmaple.Library_Mngt_demo.service;

import com.exmaple.Library_Mngt_demo.entity.IssueBook;

public interface FineService {
    double calculateFine(IssueBook issueBook);
}
