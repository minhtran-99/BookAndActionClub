package com.book.bookclub.service.impl;

import com.book.bookclub.entity.Publishing;
import com.book.bookclub.reponsitory.PublishingReponsitory;
import com.book.bookclub.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublishingServiceImpl implements PublishingService {

    @Autowired
    private PublishingReponsitory publishingReponsitory;


    @Override
    public List<Publishing> findAll() {
        return publishingReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            publishingReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Publishing create(Publishing publishing) {
        if (publishing.getPublishingId() != null){
            Publishing pubCreate = publishingReponsitory.findById(publishing.getPublishingId()).get();
            publishing.setPublishingId(publishing.getPublishingId());
            publishing.setCreateDate(pubCreate.getCreateDate());
            if (publishing.getPublishingName() == null){
                publishing.setPublishingName(pubCreate.getPublishingName());
            }
            if(publishing.getAddress() == null){
                publishing.setAddress(pubCreate.getAddress());
            }
        }
        return publishingReponsitory.save(publishing);
    }

    @Override
    public Publishing findbyId(int id) {
        return publishingReponsitory.findById(id).get();
    }
}
