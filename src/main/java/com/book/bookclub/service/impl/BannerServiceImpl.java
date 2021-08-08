package com.book.bookclub.service.impl;

import com.book.bookclub.entity.Banner;
import com.book.bookclub.reponsitory.BannerReponsitory;
import com.book.bookclub.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerReponsitory bannerReponsitory;

    @Override
    public List<Banner> findAll() {
        return bannerReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            bannerReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Banner create(Banner banner) {
        if(banner.getBannerId() != null){
            Banner bannerCreate = bannerReponsitory.findById(banner.getBannerId()).get();
            banner.setBannerId(banner.getBannerId());
            banner.setCreateDate(bannerCreate.getCreateDate());
            if(banner.getAccountId() == null){
                banner.setAccountId(bannerCreate.getAccountId());
            }
            if (banner.getImage() == null){
                banner.setImage(bannerCreate.getImage());
            }
            if (banner.getContent() == null){
                banner.setContent(bannerCreate.getContent());
            }
        }
        return bannerReponsitory.save(banner);
    }

    @Override
    public Banner findbyId(int id) {
        return bannerReponsitory.findById(id).get();
    }
}
