package com.book.bookclub.service;

import com.book.bookclub.entity.Publishing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublishingService {
    List<Publishing> findAll();
    boolean delete(int id);
    Publishing create(Publishing publishing);
    Publishing findbyId(int id);
}
