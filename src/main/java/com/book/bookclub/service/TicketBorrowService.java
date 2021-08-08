package com.book.bookclub.service;

import com.book.bookclub.entity.TicketBorrow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketBorrowService {
    List<TicketBorrow> findAll();
    boolean delete(int id);
    TicketBorrow create(TicketBorrow ticketBorrow);
    TicketBorrow findbyId(int id);
}
