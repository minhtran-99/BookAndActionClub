package com.book.bookclub.service;

import com.book.bookclub.entity.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedBackService {
    List<Feedback> findAll();
    boolean delete(int id);
    Feedback create(Feedback feedback);
    Feedback findbyId(int id);
}
