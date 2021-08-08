package com.book.bookclub.service.impl;

import com.book.bookclub.reponsitory.NewsReponsitory;
import com.book.bookclub.entity.News;
import com.book.bookclub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsReponsitory newsReponsitory;

    @Override
    public List<News> findAll() {
        return newsReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            newsReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public News create(News news) {
        if(news.getNewsId() != null){
            News newsCreate = newsReponsitory.findById(news.getNewsId()).get();
            news.setNewsId(news.getNewsId());
            news.setCreateDate(newsCreate.getCreateDate());
            if(news.getAccountId() == null){
                news.setAccountId(newsCreate.getAccountId());
            }
            if (news.getTitle() == null){
                news.setTitle(newsCreate.getTitle());
            }
            if (news.getContent() == null)
            {
                news.setTitle(newsCreate.getTitle());
            }
            if (news.getImage() == null){
                news.setImage(newsCreate.getImage());
            }
        }
        return newsReponsitory.save(news);
    }

    @Override
    public News findbyId(int id) {
        return newsReponsitory.findById(id).get();
    }
}
