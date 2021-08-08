package com.book.bookclub.service;

import com.book.bookclub.entity.ReplyFeedback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyFeedbackService {
    List<ReplyFeedback> findAll();
    boolean delete(int id);
    ReplyFeedback create(ReplyFeedback replyFeedback);
    ReplyFeedback findbyId(int id);
}
