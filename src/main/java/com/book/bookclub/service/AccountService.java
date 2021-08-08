package com.book.bookclub.service;

import com.book.bookclub.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> findAll();
    boolean delete(int id);
    Account create(Account account);
    Account findbyId(int id);
}
