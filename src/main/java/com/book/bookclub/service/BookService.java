package com.book.bookclub.service;

import com.book.bookclub.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> findAll();
    boolean delete(int id);
    Book create(Book book);
    Book findbyId(int id);
}
