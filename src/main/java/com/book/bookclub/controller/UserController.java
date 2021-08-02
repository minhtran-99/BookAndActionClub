package com.book.bookclub.controller;

import com.book.bookclub.dto.PageResult;
import com.book.bookclub.dto.ServiceResult;
import com.book.bookclub.entity.User;
import com.book.bookclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    @PreAuthorize("hasRole('Admin')")
    public PageResult getUserByPage(@PageableDefault(page = 0, size = 10, sort = "id")Pageable pageable){
        Page<User> userPage = userService.findUserByPage(pageable);
        return new PageResult(userPage);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try {
            if (userService.findByUserName(user.getUserName()) != null) {
                return ResponseEntity.badRequest().body(new ServiceResult(HttpStatus.CONFLICT.value(), "Tên đăng nhập đã có", ""));
            }
            if (userService.exitByEmail(user.getMail()) != null) {
                return ResponseEntity.badRequest().body(new ServiceResult(HttpStatus.CONTINUE.value(), "Email đã được sử dụng", ""));
            }
            userService.create(user);
            return ResponseEntity.ok(new ServiceResult(HttpStatus.OK.value(), "Success", user));
        }catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

}
