package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorReponsitory extends JpaRepository<Author, Integer> {
}