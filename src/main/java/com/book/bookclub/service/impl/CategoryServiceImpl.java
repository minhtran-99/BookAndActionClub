package com.book.bookclub.service.impl;

import com.book.bookclub.entity.Category;
import com.book.bookclub.reponsitory.CategoryReponsitory;
import com.book.bookclub.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryReponsitory categoryReponsitory;

    @Override
    public List<Category> findAll() {
        return categoryReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            categoryReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category create(Category category) {
        if (category.getCategoryId() != null){
            Category cateCreate = categoryReponsitory.findById(category.getCategoryId()).get();
            category.setCategoryId(category.getCategoryId());
            category.setCreateDate(cateCreate.getCreateDate());
            if(category.getCategoryName() == null){
                category.setCategoryName(cateCreate.getCategoryName());
            }
        }
        return categoryReponsitory.save(category);
    }

    @Override
    public Category findbyId(int id) {
        return categoryReponsitory.findById(id).get();
    }
}
