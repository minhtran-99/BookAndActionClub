package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountReponsitory extends JpaRepository<Account, Integer> {
}
