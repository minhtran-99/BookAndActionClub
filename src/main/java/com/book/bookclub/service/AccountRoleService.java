package com.book.bookclub.service;

import com.book.bookclub.entity.AccountRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountRoleService {
    List<AccountRole> findAll();
    boolean delete(int id);
    AccountRole create(AccountRole accountRole);
    AccountRole findbyId(int id);
}
