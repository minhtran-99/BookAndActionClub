package com.book.bookclub.service.impl;

import com.book.bookclub.entity.Feedback;
import com.book.bookclub.reponsitory.FeedBackReponsitory;
import com.book.bookclub.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackReponsitory feedBackReponsitory;

    @Override
    public List<Feedback> findAll() {
        return feedBackReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            feedBackReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Feedback create(Feedback feedback) {
        if(feedback.getFeedbackId() != null){
            Feedback feedCreate = feedBackReponsitory.findById(feedback.getFeedbackId()).get();
            feedback.setFeedbackId(feedback.getFeedbackId());
            feedback.setCreateDate(feedCreate.getCreateDate());
            if(feedback.getUserName() == null){
                feedback.setUserName(feedCreate.getUserName());
            }
            if(feedback.getMail() == null){
                feedback.setMail(feedCreate.getMail());
            }
            if(feedback.getContent() == null){
                feedback.setContent(feedCreate.getContent());
            }
            if(feedback.getStatus() == null){
                feedback.setStatus(feedCreate.getStatus());
            }
        }
        return feedBackReponsitory.save(feedback);
    }

    @Override
    public Feedback findbyId(int id) {
        return feedBackReponsitory.findById(id).get();
    }
}
