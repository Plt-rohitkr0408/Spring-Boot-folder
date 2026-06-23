package com.exmaple.Library_Mngt_demo.repository;

import com.exmaple.Library_Mngt_demo.entity.IssueBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueBookRepository extends JpaRepository<IssueBook,Integer> {
}
