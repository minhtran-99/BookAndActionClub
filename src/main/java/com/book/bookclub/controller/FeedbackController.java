package com.book.bookclub.controller;

import com.book.bookclub.entity.Feedback;
import com.book.bookclub.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/feedback")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeedbackController {

    @Autowired
    private FeedBackService  feedBackService;

    @GetMapping(value = "")
    public ResponseEntity<List<Feedback>> getAll(){
        List<Feedback> feedbackList = feedBackService.findAll();
        if(feedbackList != null){
            return new ResponseEntity<>(feedbackList, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Feedback feedback, @PathVariable int id){
        feedback.setFeedbackId(id);
        return new ResponseEntity<>(feedBackService.create(feedback), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody Feedback feedback){
        feedback.setCreateDate(new Date());
        return new ResponseEntity<>(feedBackService.create(feedback), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(feedBackService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(feedBackService.delete(id), HttpStatus.OK);
    }
}
