package com.book.bookclub.service.impl;

import com.book.bookclub.entity.AccountRole;
import com.book.bookclub.reponsitory.AccountRoleReponsitory;
import com.book.bookclub.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountRoleServiceImpl implements AccountRoleService {

    @Autowired
    private AccountRoleReponsitory accountRoleReponsitory;

    @Override
    public List<AccountRole> findAll() {
        return accountRoleReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            accountRoleReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public AccountRole create(AccountRole accountRole) {
        if(accountRole.getAccountRoleId() != null){
            AccountRole accRoleCreate = accountRoleReponsitory.findById(accountRole.getAccountRoleId()).get();
            accountRole.setAccountRoleId(accountRole.getAccountRoleId());
            if(accountRole.getAccountId() == null){
                accountRole.setAccountId(accRoleCreate.getAccountId());
            }
            if ((accountRole.getRoleId()) == null){
                accountRole.setRoleId(accRoleCreate.getRoleId());
            }
        }
        return accountRoleReponsitory.save(accountRole);
    }

    @Override
    public AccountRole findbyId(int id) {
        return accountRoleReponsitory.findById(id).get();
    }
}
