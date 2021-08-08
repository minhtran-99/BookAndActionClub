package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.TicketBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketBorrowReponsitory extends JpaRepository<TicketBorrow, Integer> {
}
