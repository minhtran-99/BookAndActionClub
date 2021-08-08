package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleReponsitory extends JpaRepository<Role, Integer> {
}
