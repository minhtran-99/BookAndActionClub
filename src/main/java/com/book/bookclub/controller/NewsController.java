package com.book.bookclub.controller;

import com.book.bookclub.entity.News;
import com.book.bookclub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/news")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "")
    public ResponseEntity<List<News>> getAll(){
        List<News> newsList = newsService.findAll();
        if(newsList != null){
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody News news, @PathVariable int id){
        news.setNewsId(id);
        return new ResponseEntity<>(newsService.create(news), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody News news){
        news.setCreateDate(new Date());
        return new ResponseEntity<>(newsService.create(news), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(newsService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(newsService.delete(id), HttpStatus.OK);
    }
}
