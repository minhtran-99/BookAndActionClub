package com.book.bookclub.service.impl;

import com.book.bookclub.entity.Author;
import com.book.bookclub.reponsitory.AuthorReponsitory;
import com.book.bookclub.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorReponsitory authorReponsitory;

    @Override
    public List<Author> findAll() {
        return authorReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            authorReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Author create(Author author) {
        if(author.getAuthorId() != null){
            Author auCreate = authorReponsitory.findById(author.getAuthorId()).get();
            author.setAuthorId(author.getAuthorId());
            author.setCreateDate(auCreate.getCreateDate());
            if(author.getAuthorName() == null){
                author.setAuthorName(auCreate.getAuthorName());
            }
            if(author.getNote() == null){
                author.setNote(auCreate.getNote());
            }
        }
        return authorReponsitory.save(author);
    }

    @Override
    public Author findbyId(int id) {
        return authorReponsitory.findById(id).get();
    }
}
