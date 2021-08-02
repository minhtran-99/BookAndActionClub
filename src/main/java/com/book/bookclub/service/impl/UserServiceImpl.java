package com.book.bookclub.service.impl;

import com.book.bookclub.entity.User;
import com.book.bookclub.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService {
    @Override
    public User findByUserName(String username) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public Page<User> findUserByPage(Pageable pageable) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User exitByEmail(String email) {
        return null;
    }
}
