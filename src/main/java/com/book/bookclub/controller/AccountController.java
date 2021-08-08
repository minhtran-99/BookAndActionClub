package com.book.bookclub.controller;

import com.book.bookclub.entity.Account;
import com.book.bookclub.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/account")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "")
    public ResponseEntity<List<Account>> getAll(){
        List<Account> listAcc = accountService.findAll();
        if(listAcc != null){
            return new ResponseEntity<>(listAcc, HttpStatus.OK);
        }else {
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Account account, @PathVariable int id){
        account.setAccountId(id);
        return new ResponseEntity<>(accountService.create(account), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody Account account){
        account.setCreateDate(new Date());
        return new ResponseEntity<>(accountService.create(account), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(accountService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(accountService.delete(id), HttpStatus.OK);
    }

}
