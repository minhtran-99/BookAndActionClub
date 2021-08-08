package com.book.bookclub.service;

import com.book.bookclub.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
    boolean delete(int id);
    User create(User user);
    User findbyId(int id);
}
