package com.book.bookclub.service;

import com.book.bookclub.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> findAll();
    boolean delete(int id);
    Role create(Role role);
    Role findbyId(int id);
}
