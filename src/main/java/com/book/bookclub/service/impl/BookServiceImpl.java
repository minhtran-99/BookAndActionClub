package com.book.bookclub.service.impl;

import com.book.bookclub.entity.Book;
import com.book.bookclub.reponsitory.BookReponsitory;
import com.book.bookclub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookReponsitory bookReponsitory;

    @Override
    public List<Book> findAll() {
        return bookReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            bookReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Book create(Book book) {
        if (book.getBookId() != null){
            Book bookCreate = bookReponsitory.findById(book.getBookId()).get();
            book.setBookId(book.getBookId());
            book.setCreateDate(bookCreate.getCreateDate());
            if(book.getAuthorId() == null){
                book.setAuthorId(bookCreate.getAuthorId());
            }
            if(book.getCategoryId() == null){
                book.setCategoryId(bookCreate.getCategoryId());
            }
            if(book.getPublishingId() == null){
                book.setPublishingId(bookCreate.getPublishingId());
            }
            if(book.getBookName() == null){
                book.setBookName(bookCreate.getBookName());
            }
            if(book.getQuantity() == null){
                book.setQuantity(bookCreate.getQuantity());
            }
            if(book.getYearPublishing() == null){
                book.setYearPublishing(bookCreate.getYearPublishing());
            }
            if(book.getImage() == null){
                book.setImage(bookCreate.getImage());
            }
        }
        return bookReponsitory.save(book);
    }

    @Override
    public Book findbyId(int id) {
        return bookReponsitory.findById(id).get();
    }
}
