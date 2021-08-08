package com.book.bookclub.service.impl;

import com.book.bookclub.entity.Account;
import com.book.bookclub.reponsitory.AccountReponsitory;
import com.book.bookclub.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountReponsitory accountReponsitory;

    @Override
    public List<Account> findAll() {
        return accountReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            accountReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account create(Account account) {
        if (account.getAccountId() != null){
            Account accCreate = accountReponsitory.findById(account.getAccountId()).get();
            account.setAccountId(account.getAccountId());
            account.setCreateDate(accCreate.getCreateDate());
            if(account.getAccountName() == null){
                account.setAccountName(accCreate.getAccountName());
            }
            if(account.getAccountPass() == null){
                account.setAccountPass(accCreate.getAccountPass());
            }
            if(account.getPhone() == null){
                account.setPhone(accCreate.getPhone());
            }
            if(account.getMail() == null){
                account.setMail(accCreate.getMail());
            }
            if(account.getAddress() == null){
                account.setAddress(accCreate.getAddress());
            }
            if(account.getAccountStatus() == null){
                account.setAccountStatus(accCreate.getAccountStatus());
            }
        }
        return accountReponsitory.save(account);
    }

    @Override
    public Account findbyId(int id) {
        return accountReponsitory.findById(id).get();
    }
}
