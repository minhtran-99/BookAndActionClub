package com.book.bookclub.controller;

import com.book.bookclub.entity.Publishing;
import com.book.bookclub.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/publishing")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PublishingController {

    @Autowired
    private PublishingService publishingService;

    @GetMapping(value = "")
    public ResponseEntity<List<Publishing>> getAll(){
        List<Publishing> publishingList = publishingService.findAll();
        if(publishingList != null){
            return new ResponseEntity<>(publishingList, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Publishing publishing, @PathVariable int id){
        publishing.setPublishingId(id);
        return new ResponseEntity<>(publishingService.create(publishing), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody Publishing publishing){
        publishing.setCreateDate(new Date());
        return new ResponseEntity<>(publishingService.create(publishing), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(publishingService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(publishingService.delete(id), HttpStatus.OK);
    }
}
