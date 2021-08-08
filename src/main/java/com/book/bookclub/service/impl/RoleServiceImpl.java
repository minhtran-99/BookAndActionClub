package com.book.bookclub.service.impl;

import com.book.bookclub.reponsitory.RoleReponsitory;
import com.book.bookclub.entity.Role;
import com.book.bookclub.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleReponsitory roleReponsitory;

    @Override
    public List<Role> findAll() {
        return roleReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            roleReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Role create(Role role) {
        if(role.getRoleId() != null){
            Role roleCreate = roleReponsitory.findById(role.getRoleId()).get();
            role.setRoleId(role.getRoleId());
            role.setCreateDate(roleCreate.getCreateDate());
            if(role.getRoleName() == null){
                role.setRoleName(roleCreate.getRoleName());
            }
        }
        return roleReponsitory.save(role);
    }

    @Override
    public Role findbyId(int id) {
        return roleReponsitory.findById(id).get();
    }
}
