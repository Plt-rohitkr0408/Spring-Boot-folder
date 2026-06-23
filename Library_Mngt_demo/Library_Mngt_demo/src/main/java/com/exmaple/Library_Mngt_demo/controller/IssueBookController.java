package com.exmaple.Library_Mngt_demo.controller;

import com.exmaple.Library_Mngt_demo.entity.IssueBook;
import com.exmaple.Library_Mngt_demo.service.IssueBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueBookController {

    private final IssueBookService issueBookService;

    public IssueBookController(IssueBookService issueBookService) {
        this.issueBookService = issueBookService;
    }

    @GetMapping
    public List<IssueBook> getAllIssueBooks(){
        return issueBookService.getAllIssueBooks();
    }

    @PostMapping("/book/{bookId}/student/{stdId}")
    public IssueBook addIssueBook(@PathVariable Integer bookId,@PathVariable Integer stdId){
        return issueBookService.issueBook(bookId, stdId);
    }

    @PutMapping("/return/{issueId}")
    public IssueBook returnIssueBook(@PathVariable Integer issueId){
        return issueBookService.returnBook(issueId);
    }

    @GetMapping("/{issueId}")
    public IssueBook getIssueBookById(@PathVariable Integer issueId){
        return issueBookService.getIssuebyId(issueId);
    }

}
