package com.book.bookclub.controller;

import com.book.bookclub.entity.Role;
import com.book.bookclub.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/role")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "")
    public ResponseEntity<List<Role>> getAll(){
        List<Role> roleList = roleService.findAll();
        if(roleList != null){
            return new ResponseEntity<>(roleList, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Role role, @PathVariable int id){
        role.setRoleId(id);
        return new ResponseEntity<>(roleService.create(role), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody Role role){
        role.setCreateDate(new Date());
        return new ResponseEntity<>(roleService.create(role), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(roleService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(roleService.delete(id), HttpStatus.OK);
    }
}
