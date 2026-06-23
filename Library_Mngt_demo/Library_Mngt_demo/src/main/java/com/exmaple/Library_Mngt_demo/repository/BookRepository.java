package com.exmaple.Library_Mngt_demo.repository;

import com.exmaple.Library_Mngt_demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
