package com.book.bookclub.controller;

import com.book.bookclub.entity.Book;
import com.book.bookclub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/book")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {

    @Autowired
    private BookService  bookService;

    @GetMapping(value = "")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> listBook = bookService.findAll();
        if(listBook != null){
            return new ResponseEntity<>(listBook, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Book book, @PathVariable int id){
        book.setBookId(id);
        return new ResponseEntity<>(bookService.create(book), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody Book book){
        book.setCreateDate(new Date());
        return new ResponseEntity<>(bookService.create(book), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(bookService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(bookService.delete(id), HttpStatus.OK);
    }
}
