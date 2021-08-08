package com.book.bookclub.controller;

import com.book.bookclub.entity.Banner;
import com.book.bookclub.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/banner")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BannerController {

    @Autowired
    private BannerService  bannerService;

    @GetMapping(value = "")
    public ResponseEntity<List<Banner>> getAll(){
        List<Banner> listBanner = bannerService.findAll();
        if(listBanner != null){
            return new ResponseEntity<>(listBanner, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Banner banner, @PathVariable int id){
        banner.setBannerId(id);
        return new ResponseEntity<>(bannerService.create(banner), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody Banner banner){
        banner.setCreateDate(new Date());
        return new ResponseEntity<>(bannerService.create(banner), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(bannerService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(bannerService.delete(id), HttpStatus.OK);
    }
}
