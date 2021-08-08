package com.book.bookclub.controller;

import com.book.bookclub.entity.ReplyFeedback;
import com.book.bookclub.service.ReplyFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/reply_feedback")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReplyFeedbackController {

    @Autowired
    private ReplyFeedbackService replyFeedbackService;

    @GetMapping(value = "")
    public ResponseEntity<List<ReplyFeedback>> getAll(){
        List<ReplyFeedback> replyFeedbackList = replyFeedbackService.findAll();
        if(replyFeedbackList != null){
            return new ResponseEntity<>(replyFeedbackList, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody ReplyFeedback replyFeedback, @PathVariable int id){
        replyFeedback.setReplyfeedbackId(id);
        return new ResponseEntity<>(replyFeedbackService.create(replyFeedback), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody ReplyFeedback replyFeedback){
        replyFeedback.setCreateDate(new Date());
        return new ResponseEntity<>(replyFeedbackService.create(replyFeedback), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(replyFeedbackService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(replyFeedbackService.delete(id), HttpStatus.OK);
    }
}
