package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReponsitory extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    User findByUserName(String username);

    @Override
    Page<User> findAll(Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.mail = ?1")
    User exitsByEmail(String email);
}
