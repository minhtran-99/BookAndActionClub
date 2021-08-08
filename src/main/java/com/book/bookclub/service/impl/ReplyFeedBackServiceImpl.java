package com.book.bookclub.service.impl;

import com.book.bookclub.reponsitory.ReplyFeedBackReponsitory;
import com.book.bookclub.entity.ReplyFeedback;
import com.book.bookclub.service.ReplyFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReplyFeedBackServiceImpl implements ReplyFeedbackService {

    @Autowired
    private ReplyFeedBackReponsitory replyFeedBackReponsitory;

    @Override
    public List<ReplyFeedback> findAll() {
        return replyFeedBackReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            replyFeedBackReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ReplyFeedback create(ReplyFeedback replyFeedback) {
        if (replyFeedback.getReplyfeedbackId() != null){
            ReplyFeedback replyCreate = replyFeedBackReponsitory.findById(replyFeedback.getReplyfeedbackId()).get();
            replyFeedback.setReplyfeedbackId(replyFeedback.getReplyfeedbackId());
            replyFeedback.setCreateDate(replyCreate.getCreateDate());

            if(replyFeedback.getFeedbackId() == null){
                replyFeedback.setFeedbackId(replyCreate.getFeedbackId());
            }
            if(replyFeedback.getAccountId() == null){
                replyFeedback.setAccountId(replyCreate.getAccountId());
            }
            if (replyFeedback.getReplyContent() == null){
                replyFeedback.setReplyContent(replyCreate.getReplyContent());
            }
        }
        return replyFeedBackReponsitory.save(replyFeedback);
    }

    @Override
    public ReplyFeedback findbyId(int id) {
        return replyFeedBackReponsitory.findById(id).get();
    }
}
