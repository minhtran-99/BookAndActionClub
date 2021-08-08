package com.book.bookclub.service.impl;

import com.book.bookclub.entity.User;
import com.book.bookclub.reponsitory.UserReponsitory;
import com.book.bookclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserReponsitory userReponsitory;

    @Override
    public List<User> findAll() {
        return userReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            userReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User create(User user) {
        if(user.getUserId() != null){
            User userCreate = userReponsitory.findById(user.getUserId()).get();
            user.setUserId(user.getUserId());
            user.setCreateDate(userCreate.getCreateDate());
            if(user.getAccountId() == null){
                user.setAccountId(userCreate.getAccountId());
            }
            if(user.getUserName() == null){
                user.setUserName(userCreate.getUserName());
            }
            if(user.getPassword() == null){
                user.setPassword(userCreate.getPassword());
            }
            if(user.getFullName() == null){
                user.setFullName(userCreate.getFullName());
            }
            if(user.getClassRoom() == null){
                user.setClassRoom(userCreate.getClassRoom());
            }
            if(user.getPhone() == null){
                user.setPhone(userCreate.getPhone());
            }
            if(user.getMail() == null){
                user.setMail(userCreate.getMail());
            }
            if(user.getStatus() == null){
                user.setStatus(userCreate.getStatus());
            }
        }
        return userReponsitory.save(user);
    }

    @Override
    public User findbyId(int id) {
        return userReponsitory.findById(id).get();
    }
}
