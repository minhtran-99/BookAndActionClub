package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookReponsitory extends JpaRepository<Book, Integer> {
}
