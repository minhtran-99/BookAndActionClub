package com.book.bookclub.service;

import com.book.bookclub.entity.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    List<News> findAll();
    boolean delete(int id);
    News create(News news);
    News findbyId(int id);
}
