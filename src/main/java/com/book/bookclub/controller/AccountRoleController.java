package com.book.bookclub.controller;

import com.book.bookclub.entity.AccountRole;
import com.book.bookclub.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/account_role")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountRoleController {

    @Autowired
    private AccountRoleService  accountRoleService;

    @GetMapping(value = "")
    public ResponseEntity<List<AccountRole>> getAll(){
        List<AccountRole> listAccRole = accountRoleService.findAll();
        if(listAccRole != null){
            return new ResponseEntity<>(listAccRole, HttpStatus.OK);
        }else {
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody AccountRole accountRole, @PathVariable int id){
        accountRole.setAccountRoleId(id);
        return new ResponseEntity<>(accountRoleService.create(accountRole), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody AccountRole accountRole){
        return new ResponseEntity<>(accountRoleService.create(accountRole), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(accountRoleService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(accountRoleService.delete(id), HttpStatus.OK);
    }
}
