package com.exmaple.Library_Mngt_demo.service.impl;

import com.exmaple.Library_Mngt_demo.entity.IssueBook;
import com.exmaple.Library_Mngt_demo.service.FineService;

import java.time.temporal.ChronoUnit;

public class FineServiceImpl implements FineService {
    private static final int FINE_PER_DAY = 10;
    @Override
    public double calculateFine(IssueBook issueBook) {

        if(issueBook.getReturnDate() == null){
            return 0.0;
        }

        if(issueBook.getReturnDate().isBefore(issueBook.getDueDate())) {
            return 0;
        }
       long daysLate = ChronoUnit.DAYS.between(
                issueBook.getDueDate(),
                issueBook.getReturnDate());

        return daysLate * FINE_PER_DAY;

    }
}
