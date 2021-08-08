package com.book.bookclub.controller;

import com.book.bookclub.entity.Category;
import com.book.bookclub.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {

    @Autowired
    private CategoryService  categoryService;

    @GetMapping(value = "")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> listCategory = categoryService.findAll();
        if(listCategory != null){
            return new ResponseEntity<>(listCategory, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Category category, @PathVariable int id){
        category.setCategoryId(id);
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody Category category){
        category.setCreateDate(new Date());
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(categoryService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);
    }
}
