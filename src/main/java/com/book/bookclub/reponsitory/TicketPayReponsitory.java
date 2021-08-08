package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.Ticketpay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketPayReponsitory extends JpaRepository<Ticketpay, Integer> {
}
