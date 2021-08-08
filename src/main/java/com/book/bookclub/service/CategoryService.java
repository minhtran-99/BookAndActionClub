package com.book.bookclub.service;

import com.book.bookclub.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    boolean delete(int id);
    Category create(Category category);
    Category findbyId(int id);
}
