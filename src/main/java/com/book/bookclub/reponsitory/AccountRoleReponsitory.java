package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRoleReponsitory extends JpaRepository<AccountRole, Integer> {

}
