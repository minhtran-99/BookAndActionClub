package com.book.bookclub.service;

import com.book.bookclub.entity.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BannerService {
    List<Banner> findAll();
    boolean delete(int id);
    Banner create(Banner banner);
    Banner findbyId(int id);
}
