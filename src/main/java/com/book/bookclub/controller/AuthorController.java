package com.book.bookclub.controller;

import com.book.bookclub.entity.Author;
import com.book.bookclub.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/author")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthorController {

    @Autowired
    private AuthorService  authorService;

    @GetMapping(value = "")
    public ResponseEntity<List<Author>> getAll(){
        List<Author> listAuthor = authorService.findAll();
        if(listAuthor != null){
            return new ResponseEntity<>(listAuthor, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Author author, @PathVariable int id){
        author.setAuthorId(id);
        return new ResponseEntity<>(authorService.create(author), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody Author author){
        author.setCreateDate(new Date());
        return new ResponseEntity<>(authorService.create(author), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(authorService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(authorService.delete(id), HttpStatus.OK);
    }
}
