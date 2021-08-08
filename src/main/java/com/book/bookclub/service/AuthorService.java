package com.book.bookclub.service;

import com.book.bookclub.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<Author> findAll();
    boolean delete(int id);
    Author create(Author author);
    Author findbyId(int id);
}
